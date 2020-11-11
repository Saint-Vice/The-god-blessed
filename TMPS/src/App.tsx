import React from 'react';
import './App.css';
import { Task_List } from "./todo/single"

const MyTodoLIst = Task_List.getInstance()
MyTodoLIst.setTodoSource({
  university: "MIT",
  work: "ITN",
  life: "Life"
})

export default function App() {

  MyTodoLIst.addToEat("Order Mcdonalds", "I need to order some Mcdonalds")
  MyTodoLIst.addToGetGrocery("Buy Water", "I'm out of water, so I need to go to grocery and buy some water")
  MyTodoLIst.addToWork("Work", "I need to find a workplace")
  MyTodoLIst.addToRead("Read Calculus", "Do some math")
  
  return (
    <div className="App">
      <header className="App-header">
        Check browser console please it's a DEMO
      </header>
    </div>
  );
}