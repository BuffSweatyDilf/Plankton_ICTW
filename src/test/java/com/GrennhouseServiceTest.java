package com;

import com.model.Greenhouse;
import com.repository.GreenhouseRepository;
import com.service.GreenhouseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GreenhouseServiceTest {

    @Mock
    private GreenhouseRepository greenhouseRepositoryMock;

    @InjectMocks
    private GreenhouseService greenhouseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGreenhouses() {
        List<Greenhouse> mockGreenhouses = new ArrayList<>();
        when(greenhouseRepositoryMock.findAll()).thenReturn(mockGreenhouses);

        List<Greenhouse> result = greenhouseService.getAllGreenhouses();

        assertEquals(mockGreenhouses, result);
    }

    @Test
    void testGetGreenhouseById() {
        Long id = 1L;
        Greenhouse mockGreenhouse = new Greenhouse();
        when(greenhouseRepositoryMock.findById(id)).thenReturn(Optional.of(mockGreenhouse));

        Greenhouse result = greenhouseService.getGreenhouseById(id);

        assertEquals(mockGreenhouse, result);
    }

    @Test
    void testGetGreenhouseByIdNotFound() {
        Long id = 1L;
        when(greenhouseRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> greenhouseService.getGreenhouseById(id));
    }

    @Test
    void testCreateGreenhouse() {
        Greenhouse mockGreenhouse = new Greenhouse();
        when(greenhouseRepositoryMock.save(mockGreenhouse)).thenReturn(mockGreenhouse);

        Greenhouse result = greenhouseService.createGreenhouse(mockGreenhouse);

        assertEquals(mockGreenhouse, result);
    }

    @Test
    void testUpdateGreenhouse() {
        Long id = 1L;
        Greenhouse mockGreenhouse = new Greenhouse();
        when(greenhouseRepositoryMock.findById(id)).thenReturn(Optional.of(mockGreenhouse));
        when(greenhouseRepositoryMock.save(mockGreenhouse)).thenReturn(mockGreenhouse);

        Greenhouse updatedGreenhouse = new Greenhouse();
        updatedGreenhouse.setName("Updated Name");
        updatedGreenhouse.setLocation("Updated Location");
        Greenhouse result = greenhouseService.updateGreenhouse(id, updatedGreenhouse);

        assertEquals(updatedGreenhouse.getName(), result.getName());
        assertEquals(updatedGreenhouse.getLocation(), result.getLocation());
    }

    @Test
    void testDeleteGreenhouse() {
        Long id = 1L;
        doNothing().when(greenhouseRepositoryMock).deleteById(id);

        greenhouseService.deleteGreenhouse(id);

        verify(greenhouseRepositoryMock, times(1)).deleteById(id);
    }
}