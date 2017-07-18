package com.webservice.requestpojo.specificcountry;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestResponse {

@SerializedName("messages")
@Expose
private List<String> messages = null;
@SerializedName("result")
@Expose
private Result result;

public List<String> getMessages() {
return messages;
}

public void setMessages(List<String> messages) {
this.messages = messages;
}

public Result getResult() {
return result;
}

public void setResult(Result result) {
this.result = result;
}

}
