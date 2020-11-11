import { Task_Interface } from "./todo";
import { NotificationFactory } from "./notification";

export class Organizer {
  private emailNotification = new NotificationFactory().createEmailNotification();
  private smsNotification = new NotificationFactory().createSMSNotification();
  private finished: Task_Interface[] = [];
  private todo: Task_Interface[] = [];
  private doing: Task_Interface[] = [];

  constructor() {}

  addViaEmailTask(task: Task_Interface): void {
    this.todo.push(task);
    this.emailNotification.send({
      recipient: task.source,
      title: `Please do this: ${task.payload}`,
      description: `Because: ${task.description}`,
    });
  }
  addViaSmsTask(task: Task_Interface): void {
    this.todo.push(task);
    this.smsNotification.send({
      recipient: task.source,
      title: `Please do this: ${task.payload}`,
      description: `Because: ${task.description}`,
    });
  }
}
