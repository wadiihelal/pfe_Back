package com.example.testagg.service.stations;

import com.example.testagg.repo.stations.BookAssemblyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAssemblyService
{
    @Autowired
    BookAssemblyRepo bookAssemblyRepo;

    public List findAll() {
        return bookAssemblyRepo.findAll();
    }
    public List findBookAssembliesByStatus(String status) {
        return bookAssemblyRepo.findBookAssembliesByStatus(status);
    }
}
