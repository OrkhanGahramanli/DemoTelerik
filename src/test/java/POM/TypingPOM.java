package POM;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class TypingPOM {

    private TypingPOM(){

    }
private static TypingPOM Instance;

public static TypingPOM getInstance(){
    if (Instance==null){
        Instance = new TypingPOM();
    }
    return Instance;
}

private final By typingTestLink = By.xpath("//*[@mode='speedtest']");
private final By cookieDeclineBtn = By.id("CybotCookiebotDialogBodyButtonDecline");
private final By inputTextField = By.className("form-control");
private final By textWord = By.xpath("//*[@id='row1']/span");
}
