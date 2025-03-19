package com.cg.btb.test;



import com.sprint.btb.entity.BusEntity;
import com.sprint.btb.exception.BadRequestException;
import com.sprint.btb.model.BusModel;
import com.sprint.btb.repo.BusRepository;
import com.sprint.btb.service.BusServiceImpl;
import com.sprint.btb.util.BTBUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BusServiceImplTest {

    @Mock
    private BusRepository busRepo;

    @Mock
    private BTBUtil btbUtil;

    @InjectMocks
    private BusServiceImpl busService;

    private BusEntity busEntity;
    private BusModel busModel;

    @BeforeEach
    public void setUp() {
       
        busEntity = new BusEntity();
        busEntity.setBusId(1);
        busEntity.setBusType(BusEntity.BusType.Ac); 
        busEntity.setCapacity(50);

        busModel = new BusModel();
        busModel.setBusId(1);
        busModel.setBusType(BusEntity.BusType.Ac);  
        busModel.setCapacity(50);
    }

    

    @Test
    public void testGetBusById_BusNotFound() {
        when(busRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> busService.getBusById(1));
    }
    
    @Test
    public void testGetBusSeatCapacity_Success() throws BadRequestException {
        when(busRepo.findById(1)).thenReturn(Optional.of(busEntity));

        int seatCapacity = busService.getBusSeatCapacity(1);

        assertNotNull(seatCapacity);
        assertEquals(50, seatCapacity);
    }

 

    @Test
    public void testDeleteBusById_BusNotFound() {
        when(busRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> busService.deleteBusById(1));
    }

    
    @Test
    public void testGetAllBuses_NoBusesFound() {
        when(busRepo.findAll()).thenReturn(new ArrayList<>());

        assertThrows(BadRequestException.class, () -> busService.getAllBuses());
    }
   

    @Test
    public void testGetBusesByType_BusNotFound() {
        when(busRepo.findByBusType(BusEntity.BusType.Ac)).thenReturn(new ArrayList<>());

        assertThrows(BadRequestException.class, () -> busService.getBusesByType(BusEntity.BusType.Ac));
    }

  
    @Test
    public void testGetBusSeatCapacity_BusNotFound() {
        when(busRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(BadRequestException.class, () -> busService.getBusSeatCapacity(1));
    }
}

