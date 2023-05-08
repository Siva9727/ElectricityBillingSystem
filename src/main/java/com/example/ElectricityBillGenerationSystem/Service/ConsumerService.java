package com.example.ElectricityBillGenerationSystem.Service;


import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.DTOs.UpdateConsumerDto;
import com.example.ElectricityBillGenerationSystem.Mappers.*;
import com.example.ElectricityBillGenerationSystem.Model.*;
import com.example.ElectricityBillGenerationSystem.Repository.BillRepository;
import com.example.ElectricityBillGenerationSystem.Repository.ConsumerRepository;
import com.example.ElectricityBillGenerationSystem.Repository.ReadingRepository;
import com.example.ElectricityBillGenerationSystem.Repository.SlabRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    SlabRepository slabRepository;

    @Autowired
    ReadingRepository readingRepository;



    public String addConsumer(Consumer consumer) {
//        Consumer consumer1 =new Consumer();
//        consumer1.setName(consumer.getName());
//        consumer1.setEmail(consumer.getEmail());
//        consumer1.setPassword(consumer.getPassword());
//        consumer1.setMobNo(consumer.getMobNo());
//        consumer1.setCity(consumer.getCity());

        // use builder
//        Consumer consumer1 = Consumer.builder()
//                .name(consumer.getName())
//                .email(consumer.getEmail())
//                .password(consumer.getPassword())
//                .mobNo(consumer.getMobNo())
//                .city(consumer.getCity())
//                .build();

        Consumer consumer1 = AddConsumerMapper.addConsumerDetails(consumer);


        Admin admin = consumer1.getAdmin();

//        Reading reading = new Reading();
//        reading.setConsumer(consumer1);
//        reading.setCurrentReading(0);
//        reading.setAdmin(admin);

        Reading reading = Reading.builder().consumer(consumer1).CurrentReading(0).admin(admin).build();

//        Reading reading = AddConsumerMapper.setInitialReading(consumer1,admin);
//
        List<Reading> readingList = consumer1.getReadingList();
        if (readingList == null) {
            readingList = new ArrayList<>();
        }
        readingList.add(reading);
        consumer1.setReadingList(readingList);


         consumerRepository.save(consumer1);
         return "consumer created successfully";
    }


    public BillDto generateBill(int id) {
        Consumer consumer = consumerRepository.findById(id).get();

            Admin admin = consumer.getAdmin();


            //Units
            List<Reading> readingList = readingRepository.findLatestTwoReadingsByConsumerId(consumer.getId());

            int units = calculateUnits(readingList);

            //Slab rate
//        List<Slab> slabList = slabRepository.findAll();
//        double firstSlab = slabList.get(0).getSlab_Rate();
//        double secondSlab = slabList.get(1).getSlab_Rate();
//        double thirdSlab = slabList.get(2).getSlab_Rate();
//        double fourthSlab = slabList.get(3).getSlab_Rate();
//
//        double firstMinUnit = slabList.get(0).getMinUnit();
//        double firstMaxUnit = slabList.get(0).getMaxUnit();
//        double secondMinUnit = slabList.get(1).getMinUnit();
//        double secondMaxUnit = slabList.get(1).getMaxUnit();
//        double thirdMinUnit = slabList.get(2).getMinUnit();
//        double thirdMaxUnit = slabList.get(2).getMaxUnit();
//        double fourthMinUnit = slabList.get(3).getMinUnit();
//        double fourthMaxUnit = slabList.get(3).getMaxUnit();
//
//
//        double bill_amount;
//        if (units>=firstMinUnit && units<=firstMaxUnit) {
//            bill_amount = units * firstSlab;
//        } else if (units>=secondMinUnit && units<=secondMaxUnit) {
//            bill_amount = firstMaxUnit*firstSlab+ (secondMaxUnit-units)*secondSlab;
//        } else if (units>=thirdMinUnit && units<=thirdMaxUnit) {
//            bill_amount = firstMaxUnit*firstSlab+(secondMaxUnit-secondMinUnit)*secondSlab+(thirdMaxUnit-units)*thirdSlab;
//        }else {
//            bill_amount = firstMaxUnit*firstSlab+(secondMaxUnit-secondMinUnit)*secondSlab+(thirdMaxUnit-thirdMinUnit)*thirdSlab+(fourthMaxUnit-units)*firstSlab;
//        }

            List<Slab> slabList = slabRepository.findAll(Sort.by("minUnit"));

            double bill_amount = 0;
            double remainingUnits = units;

            for (Slab slab : slabList) {
                double slabRate = slab.getSlab_Rate();
                double minUnit = slab.getMinUnit();
                double maxUnit = slab.getMaxUnit();

                if (remainingUnits > 0) {
                    double slabUnits = Math.min(remainingUnits, maxUnit - minUnit);
                    bill_amount += slabUnits * slabRate;
                    remainingUnits -= slabUnits;
                }
            }

            //period
            String period = readingList.get(0).getReadingDate() +" to " + readingList.get(1).getReadingDate();

            //bill amount

//        BillDto bill = new BillDto();
//
//        bill.setCustomer_ID(id);
//        bill.setCustomer_Name(consumer.getName());
//        bill.setConsumption_Units(units);
//        bill.setBill_Amount(bill_amount);
//        bill.setPeriod(period);

//        BillDto bill = BillDto.builder()
//                .Customer_ID(id)
//                .Customer_Name(consumer.getName())
//                .Consumption_Units(units)
//                .Bill_Amount(bill_amount)
//                .Period(period)
//                .build();

            BillDto bill = BillDtoMapper.BillDtoGeneration(id,consumer,units,bill_amount,period);



            // dto to bill
//        Bill ogBill = new Bill();
//        ogBill.setBill_Amount(bill.getBill_Amount());
//        ogBill.setAdmin(admin);
//        ogBill.setConsumer(consumer);
//        ogBill.setCustomer_Name(consumer.getName());
//        ogBill.setPeriod(bill.getPeriod());
//        ogBill.setConsumption_Units(bill.getConsumption_Units());

//        Bill ogBill = Bill.builder()
//                .billGeneratedOn(bill.getBillGeneratedOn())
//                .Bill_Amount(bill.getBill_Amount())
//                .admin(admin)
//                .consumer(consumer)
//                .Consumption_Units(bill.getConsumption_Units())
//                .Customer_Name(consumer.getName())
//                .Period(bill.getPeriod())
//                .build();

            Bill ogBill = BillGenerationMapper.generate(bill,admin,consumer);

            billRepository.save(ogBill);

            return getBill(ogBill.getConsumer().getId());


    }

    public String updateConsumerDetails(UpdateConsumerDto updateConsumerDto){

        // convert dto entity
//        Consumer originalConsumer = consumerRepository.findById(updateConsumerDto.getId()).get();
//
//        originalConsumer.setCity(updateConsumerDto.getCity());
//        originalConsumer.setMobNo(updateConsumerDto.getMobNo());
//        originalConsumer.setName(updateConsumerDto.getName());
//        originalConsumer.setEmail(updateConsumerDto.getEmail());
//        originalConsumer.setPassword(updateConsumerDto.getPassword());


        Consumer originalConsumer =  UpdateConsumerMapper.updateConsumer(updateConsumerDto);
        // save entity to repo
        consumerRepository.save(originalConsumer);

        return "consumer details updated";

    }


    public BillDto getBill(int consumerId){

        Bill bill =  billRepository.findBillByConsumerId(consumerId);

//        BillDto billDto = new BillDto();
//        billDto.setBill_Amount(bill.getBill_Amount());
//        billDto.setPeriod(bill.getPeriod());
//        billDto.setCustomer_ID(bill.getConsumer().getId());
//        billDto.setCustomer_Name(bill.getCustomer_Name());
//        billDto.setBillGeneratedOn(bill.getBillGeneratedOn());
//        billDto.setConsumption_Units(bill.getConsumption_Units());


//        BillDto billDto = BillDto.builder()
//                .Bill_Amount(bill.getBill_Amount())
//                .Period(bill.getPeriod())
//                .Customer_ID(bill.getConsumer().getId())
//                .Customer_Name(bill.getCustomer_Name())
//                .billGeneratedOn(bill.getBillGeneratedOn())
//                .Consumption_Units(bill.getConsumption_Units())
//                .build();

        BillDto billDto = GetBillMapper.getBillMapping(bill);

        return billDto;
    }


    public int calculateUnits(List<Reading> readings) {
        int n = readings.size();
        if (n < 2) {
            return 0;
        }

        Reading current = readings.get(0);
        Reading previous = readings.get(1);

        return current.getCurrentReading() - previous.getCurrentReading();

    }
}
