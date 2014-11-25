package org.sample.lambda;

import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeAsyncRequest;
import com.amazonaws.services.lambda.model.InvokeAsyncResult;

public class Sample {
	public static void main(String[] args){
		Sample sample = new Sample();
		sample.invokeLambdaFunction();
	}
	
	private void invokeLambdaFunction(){
		AWSLambdaClient lambda = new AWSLambdaClient();
		
		InvokeAsyncRequest invokeAsyncRequest = new InvokeAsyncRequest();
		invokeAsyncRequest.setFunctionName("invoke-from-sdk");
		invokeAsyncRequest.setInvokeArgs("{\"key1\":\"from java\"}");
		
		InvokeAsyncResult invokeAsyncResult = lambda.invokeAsync(invokeAsyncRequest);
		int status = invokeAsyncResult.getStatus().intValue();
		
		if(status == 202){
			System.out.println("success");
		}
	}
}
