package com.spo.service;

import com.spo.model.CleanerRequest;
import com.spo.model.CleanerResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CleanerServiceTest {

    private CleanerService cleanerService = new CleanerService();

    @Test
    public void shouldCalculateCapacityOnlySeniors() {
        CleanerRequest request = new CleanerRequest();
        request.setJunior(6);
        request.setSenior(10);
        ArrayList<Integer> rooms = new ArrayList<>();
        rooms.add(30);
        request.setRooms(rooms);
        List<CleanerResponse> result = cleanerService.calculate(request);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(3, result.get(0).getSenior());
        Assert.assertEquals(0, result.get(0).getJunior());

    }

    @Test
    public void shouldCalculateCapacityWith2Juniors() {
        CleanerRequest request = new CleanerRequest();
        request.setJunior(6);
        request.setSenior(10);
        ArrayList<Integer> rooms = new ArrayList<>();
        rooms.add(21);
        request.setRooms(rooms);
        List<CleanerResponse> result = cleanerService.calculate(request);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.get(0).getSenior());
        Assert.assertEquals(2, result.get(0).getJunior());

    }

    @Test
    public void shouldCalculateCapacity() {
        CleanerRequest request = new CleanerRequest();
        request.setJunior(6);
        request.setSenior(11);
        ArrayList<Integer> rooms = new ArrayList<>();
        rooms.add(24);
        request.setRooms(rooms);
        List<CleanerResponse> result = cleanerService.calculate(request);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(2, result.get(0).getSenior());
        Assert.assertEquals(1, result.get(0).getJunior());

    }

    @Test
    public void shouldCalculateCapacityWith1Junior() {
        CleanerRequest request = new CleanerRequest();
        request.setJunior(6);
        request.setSenior(10);
        ArrayList<Integer> rooms = new ArrayList<>();
        rooms.add(33);
        request.setRooms(rooms);
        List<CleanerResponse> result = cleanerService.calculate(request);

        Assert.assertEquals(1, result.size());
        Assert.assertEquals(3, result.get(0).getSenior());
        Assert.assertEquals(1, result.get(0).getJunior());

    }
}
