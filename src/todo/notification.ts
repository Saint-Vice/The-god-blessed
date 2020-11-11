interface Interface_Notification {
  send(props: Interface_NotificationProps): void;
}

interface Interface_NotificationProps {
  title: string;
  description: string;
  recipient: string;
}

class EmailNotification implements Interface_Notification {
  system: any;

  constructor(emailSystemDependency: any) {
    this.system = {
      MakeEmailRequest: (props: Interface_Notification) => null,
    };
  }

  send(props: Interface_NotificationProps): void {
    this.system.MakeEmailRequest(props);
    console.log(`EMAIL: ${props.recipient}  "${props.title}" `);
  }
}

class SmsNotification implements Interface_Notification {
  system: any;

  constructor(smsNotificationDependency: any) {
    this.system = {
      MakeSmsRequest: (props: Interface_Notification) => null,
    };
  }

  send(props: Interface_NotificationProps): void {
    this.system.MakeSmsRequest(props);
    console.log(`SMS: ${props.recipient}  "${props.title}" `);
  }
}
/**
 *  Factory
 */
export class NotificationFactory {
  createEmailNotification(): Interface_Notification {
    const EmailDependency = null;
    return new EmailNotification(EmailDependency);
  }
  createSMSNotification(): Interface_Notification {
    const SMSdependency = null;
    return new SmsNotification(SMSdependency);
  }
}
