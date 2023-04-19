package com.example.ElectricityBillGenerationSystem.Service;

import com.example.ElectricityBillGenerationSystem.DTOs.BillDto;
import com.example.ElectricityBillGenerationSystem.DTOs.SetReadingDto;
import com.example.ElectricityBillGenerationSystem.DTOs.UpdateConsumerDto;
import com.example.ElectricityBillGenerationSystem.DTOs.UpdateSlabRequestDto;
import com.example.ElectricityBillGenerationSystem.Model.*;
import com.example.ElectricityBillGenerationSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    BillRepository billRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    ConsumerRepository consumerRepository;

    @Autowired
    SlabRepository slabRepository;

    public String registerAdmin(Admin admin){
        Admin admin1 = new Admin();

        admin1.setUsername(admin.getUsername());
        admin1.setPassword(admin.getPassword());

        adminRepository.save(admin1);

        return "Registration Successful!";
    }


    public String setReading(SetReadingDto setReadingDto) {
        Consumer consumer =  consumerRepository.findById(setReadingDto.getConsumerId()).get();
        Admin admin = adminRepository.findById(setReadingDto.getAdminId()).get();

        List<Reading> readingList = consumer.getReadingList();

//        Reading reading = new Reading();
//        reading.setCurrentReading(setReadingDto.getCurrentReading());
//        reading.setAdmin(admin);
//        reading.setConsumer(consumer);
        Reading reading = Reading.builder()
                .CurrentReading(setReadingDto.getCurrentReading())
                .admin(admin)
                .consumer(consumer)
                .build();

        readingList.add(reading);

        consumer.setReadingList(readingList);
//        consumer.setSlab(admin.getSlabList().get());
        consumer.setAdmin(admin);
//        consumer.setSlabList(admin.getSlabList());
//        readingRepository.save(reading);
//        consumer.setSlabList(admin.getSlabList());

        consumerRepository.save(consumer);

        return "Reading Set for customer!";
    }

    public String updateConsumerDetails(UpdateConsumerDto updateConsumerDto){

        Consumer originalConsumer = consumerRepository.findById(updateConsumerDto.getId()).get();

        originalConsumer.setCity(updateConsumerDto.getCity());
        originalConsumer.setMobNo(updateConsumerDto.getMobNo());
        originalConsumer.setName(updateConsumerDto.getName());
        originalConsumer.setEmail(updateConsumerDto.getEmail());
        originalConsumer.setPassword(updateConsumerDto.getPassword());

        // save entity to repo
        consumerRepository.save(originalConsumer);

        return "consumer updated";
    }

    public String deleteUser(int id){
        consumerRepository.deleteById(id);
        return "consumer deleted";
    }

    public String updateSlab(UpdateSlabRequestDto updateSlabRequestDto){
        // convert dto to entity
        Slab originalSlab = slabRepository.findById(updateSlabRequestDto.getId()).get();

        // set slab new slab rate and don't change anything else

        originalSlab.setSlab_Rate(updateSlabRequestDto.getSlabRate());

        // save entity to repo

        slabRepository.save(originalSlab);


        return "Updated slab rate";
    }

    public List<BillDto> getAllBills(){
        List<Bill> billList = billRepository.findAll();
        List<BillDto> billDtoList = new ArrayList<>();

        for (Bill bill : billList){
            BillDto billDto = new BillDto();
            billDto.setConsumption_Units(bill.getConsumption_Units());
            billDto.setCustomer_Name(bill.getCustomer_Name());
            billDto.setPeriod(bill.getPeriod());
            billDto.setBill_Amount(bill.getBill_Amount());
            billDto.setCustomer_ID(bill.getConsumer().getId());
            billDto.setBillGeneratedOn(bill.getBillGeneratedOn());

            billDtoList.add(billDto);
        }
        return billDtoList;
    }

}
