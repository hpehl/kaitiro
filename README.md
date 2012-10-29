Kaitiro ([Maori for "observer"](http://www.maoridictionary.co.nz/index.cfm?dictionaryKeywords=observer)) brings the observer feature from CDI (JSR-299/JSR-330) to GWT. 

Using CDI you can easily define custom events / listeners:
```java
public class HelloEvent { 
    private final String message; 

    public HelloEvent(String message) { 
        this.message = message; 
    } 

    public String getMessage() { 
        return message; 
    } 
} 

public class HelloMessenger { 
    @Inject Event<HelloEvent> event; 

    public void hello() { 
        event.fire(new HelloEvent("Hi there " + System.currentTimeMillis())); 
    } 
} 

public class HelloListener { 
    public void listenToHello(@Observes HelloEvent helloEvent) { 
        System.out.println("HelloEvent: " + helloEvent); 
    } 
} 
```

Kaitiro aims to bring this programming model to GWT / GIN. For a reasonable implementation Kaitiro needs to participate in GINs dependency injection mechanism. There's an ongoing discussion to implement some kind of GinExtensions. Kaitiro would use such an extension to generate the necessary code for GwtEvents and EventHandlers that integrate nicley with the new GWT EventBus. 

For more details about the planned GIN extensions see 
  * http://code.google.com/p/google-gin/issues/detail?id=95
  * http://groups.google.com/group/google-gin/browse_thread/thread/7dd7382be803e00b
  * http://codereview.appspot.com/3297042

Kaitiro is currently in the design phase. Any ideas, suggestions and comments are welcome!
