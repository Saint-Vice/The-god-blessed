import { TodoListProxy } from "../main";

export class User {
  run() {
    const mySystem = TodoListProxy.getInstance();

    const unregisteredUser = "invalidTocken";
    const registeredUser = "validTocken";

    mySystem.authoriseAndRun(registeredUser, () =>
      mySystem.setTodoSource({
        university: "MIT",
        work: "ITN",
        life: "Life",
      })
    );
    mySystem.authoriseAndRun(registeredUser, () =>
      mySystem.addToEat("Order Mcdonalds", "I need to order some Mcdonalds")
    );
    mySystem.authoriseAndRun(registeredUser, () =>
      mySystem.addToGetGrocery("Buy Water", "I'm out of water, so I need to go to grocery and buy some water")
    );
    mySystem.authoriseAndRun(registeredUser, () =>
      mySystem.addToWork(
        "Work",
        "I need to find a workplace"
      )
    );
    mySystem.authoriseAndRun(registeredUser, () =>
      mySystem.addToRead(
        "Read Calculus",
        "I need to do some math"
      )
    );
  }
}
