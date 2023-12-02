import java.util.*;
import java.net.*;
import java.io.*;

public class CurrencyConverter {
	// API key
	static final String apikey="d13aa9c186ba0296e2627c73";
	
	public static void main(String []args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Currency Converter");
		
		// input for the Currency that has to converted
		System.out.println("Enter the Currency to convert: ");
		String currency=sc.nextLine().toUpperCase();
		
		// input for the Target Currency
		System.out.println("Enter the Target Currency: ");
		String targetCurrency = sc.nextLine().toUpperCase();
		
		// input for the amount that has to converted from Target Currency
		System.out.println("Enter the amount to convert: ");
		double amount=sc.nextDouble();
		
		// Calling the convert method to convert the currency and display the result
		convert(amount, currency, targetCurrency);
		System.out.println("Conversion Complete!!");
	}
	
	// Method to convert to targetCurrency and display the value for amount
	public static void convert(double amount, String currency, String targetCurrency) throws IOException {
		
		// calling the Exchange rate method and storing the value in variable
		double rate=ExchageRate(currency, targetCurrency);
		double value = (double)amount * rate;
		System.out.println(amount+" "+currency+" = "+value+" "+targetCurrency);
	}
	
	public static double ExchageRate(String currency, String targetCurrency) throws IOException {
		
		// API for getting exchange rates of the currency
		String apiUrl = "https://v6.exchangerate-api.com/v6/"+apikey+"/latest/"+currency;
		
		// Making the request using the url class
		URL url = new URL(apiUrl);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder response=new StringBuilder();
		String next;
		
		while((next=reader.readLine())!=null) {
			response.append(next);
		}
		reader.close(); 
		con.disconnect();
		
		// Converting to JSON
		String jsonResponse = response.toString();
		int start = jsonResponse.indexOf(targetCurrency)+5;
		int end= jsonResponse.indexOf(",",start);
		String rate=jsonResponse.substring(start, end);
		// returning the exchange rate of the currency
		return Double.parseDouble(rate);
	}
}
