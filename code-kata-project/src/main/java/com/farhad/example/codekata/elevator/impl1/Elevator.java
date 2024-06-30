package com.farhad.example.codekata.elevator.impl1;

import java.util.PriorityQueue;

public class Elevator {


    private int currentFloor;
    private Direction direction;
    private PriorityQueue<Request> upQueue;
    private PriorityQueue<Request> downQueue;

    public Elevator(int currentFloor) {
        this(
            currentFloor, 
            Direction.IDLE, 
            new PriorityQueue<Request>((o1, o2) -> o1.getDesiredFloor() - o2.getDesiredFloor()), 
            new PriorityQueue<Request>((o1, o2) -> o2.getDesiredFloor() - o1.getDesiredFloor()));
        
    }

    public Elevator(int currentFloor, Direction direction, PriorityQueue<Request> upQueue,
            PriorityQueue<Request> downQueue) {
                this.currentFloor = currentFloor;
                this.direction = direction;
                this.upQueue = upQueue;
                this.downQueue = downQueue;
    }

    public void sendDownRequest(Request downRequest) {
        if(downRequest.getLocation() == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(
                new Request(downRequest.getCurrentFloor(), downRequest.getCurrentFloor(), Direction.DOWN, Location.OUTSIDE_ELEVATOR));
                System.out.println("Append Down request going to floor " + downRequest.getCurrentFloor() + ".");
        }
        downQueue.offer(downRequest);
        System.out.println("Append Down request going to floor " + downRequest.getDesiredFloor() + ".");
    }

    public void sendUpRequest(Request upRequest) {
        if(upRequest.getLocation() == Location.OUTSIDE_ELEVATOR) {
            upQueue.offer(
                new Request(upRequest.getCurrentFloor(), upRequest.getCurrentFloor(), Direction.UP, Location.OUTSIDE_ELEVATOR));
                System.out.println("Append up request going to floor " + upRequest.getCurrentFloor() + ".");
        }
        upQueue.offer(upRequest);
        System.out.println("Append up request going to floor " + upRequest.getDesiredFloor() + ".");
    }

    public void run() {
        while(!upQueue.isEmpty() || !downQueue.isEmpty()){
            processRequests();
        }
        System.out.println("Finished!");
        this.direction = Direction.IDLE;
    }

    private void processRequests() {
        if(this.direction == Direction.UP || this.direction == Direction.IDLE){
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    private void processUpRequest() {
        while (!upQueue.isEmpty()) {
            Request request = upQueue.poll();
            this.currentFloor = request.getDesiredFloor();
            System.out.println("Processing up requests(" +  request +"). Elevator stopped at floor " + this.currentFloor + ".");
        }

        if(!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }

    }

    private void processDownRequest() {
        while (!downQueue.isEmpty()) {
            Request request = downQueue.poll();
            this.currentFloor = request.getDesiredFloor();
            System.out.println("Processing down requests(" +  request +"). Elevator stopped at floor " + this.currentFloor + ".");
        }

        if(!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }

    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(0);
        Request upRequest1 = new Request(elevator.currentFloor, 5, Direction.UP, Location.INSIDE_ELEVATOR);
        Request upRequest2 = new Request(elevator.currentFloor, 3, Direction.UP, Location.INSIDE_ELEVATOR);

        Request downRequest1 = new Request(elevator.currentFloor, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest2 = new Request(elevator.currentFloor, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(4, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);

        elevator.sendUpRequest(upRequest1);
        elevator.sendUpRequest(upRequest2);

        elevator.sendDownRequest(downRequest3);

        elevator.sendDownRequest(downRequest1);
        elevator.sendDownRequest(downRequest2);

        elevator.run();
    }

}
