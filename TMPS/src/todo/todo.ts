export enum Task_Type {
  grocery = "McDonalds",
  read = "read a book",
  eat = "eat",
  work = "to finish the task",
  other = "other",
}

export interface Task_Interface {
  id: number;
  type: Task_Type;
  payload: string;
  description: string;
  source: string;
}

export class Todo implements Task_Interface {
  id: number = 0;
  type: Task_Type = Task_Type.other;
  payload: string = "";
  description: string = "";
  source: string = "";

  constructor(id: number) {
    this.id = id;
  }
}
