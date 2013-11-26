package com.example.onq;

import java.util.ArrayList;
import java.util.List;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;

public class MainActivity extends Activity {

	private List<QCard> javaCardList = new ArrayList<QCard>();
	private List<QCard> cPlusCardList = new ArrayList<QCard>();
	private List<QCard> beerCardList = new ArrayList<QCard>();
	private List<QCardSet> qCardSetList = new ArrayList<QCardSet>();
	private ArrayList<QCard> cardList = new ArrayList<QCard>();
	private Button studyButton;
	private Button bumpButton;
	private Paint paint;
	public static Bitmap tmpB;
	public static Activity tmpActivity;
	private String theSetName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		tmpActivity = MainActivity.this;
		paint = new Paint();
        paint.setColor(Color.GREEN);
        tmpB = BitmapFactory.decodeResource(getResources(),R.drawable.card);
        setTheSetName("BeerQuestions");
        populateBeerCards();
		populateJavaCards();
		studyButton = (Button) findViewById(R.id.StudyButton);
	
		studyButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tmpActivity = MainActivity.this;
				Intent intent = new Intent(MainActivity.this, FlipActivity.class);
				startActivityForResult(intent,0);
			}
		});
		
		
		bumpButton = (Button) findViewById(R.id.BumpButton);
				
		bumpButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, BumpDeck.class);
				intent = intent.putExtra("Cards", cardList);
				startActivityForResult(intent,0);
			}
		});
	}
	private void populateBeerCards(){
		QCard tmp = new QCard();
		
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.beer);
		Bitmap currentThumb = ThumbnailUtils.extractThumbnail(bm, 50, 50);
		
		tmp.setQuestion("The ancient Babylonians were the first to brew beer. If you brewed a bad batch back then what was the punishment?");
		tmp.setAnswer("If you brewed a bad batch you would be drowned in it.");
		tmp.setqPic(currentThumb);
		tmp.setSetName("BeerQuestions");
		beerCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("Why should you store your beer upright?");
		tmp.setAnswer("Upright storage minimizes oxidation and contamination from the cap.");
		tmp.setqPic(currentThumb);
		tmp.setSetName("BeerQuestions");
		beerCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("What did the Vikings believe would provide them with an endless supply of beer when they reached Valhalla?");
		tmp.setAnswer("A giant goat whose udders provided the beer.");
		tmp.setqPic(currentThumb);
		tmp.setSetName("BeerQuestions");
		beerCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("When prohibition ended in the US what was the first thing President Roosevelt said?");
		tmp.setAnswer("'What America needs now is a drink'-Roosevelt.");
		tmp.setqPic(currentThumb);
		tmp.setSetName("BeerQuestions");
		beerCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("What is the most expensive kind of beer sold in the world today?");
		tmp.setAnswer("The most expensive beer sold in the world today is Vielle Bon Secours selling at approximately 1000 dollars per bottle.");
		tmp.setqPic(currentThumb);
		tmp.setSetName("BeerQuestions");
		beerCardList.add(tmp);
		
		QCardSet tmpSet = new QCardSet();
		tmpSet.setCardListName("BeerQuestions");
		tmpSet.setqCardsList(beerCardList);
		
		qCardSetList.add(tmpSet);
		
	}
	
	private void populateCPlusCards(){
		QCard tmp = new QCard();
		
		tmp.setQuestion("Give an example for a variable 'const' and 'volatile'. Is it possible?");
		tmp.setAnswer("Yes, a status register for a microcontroller.");
		tmp.setSetName("C++Questions");
		cPlusCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("How do you detect if a linked list is circular?");
		tmp.setAnswer("You need to use 2 pointers, one incrementing by 1 and another by 2. If the list is circular, then pointer that is incremented by 2 elements will pass over the first pointer.");
		tmp.setSetName("C++Questions");
		cPlusCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("Define a 'dangling' pointer?");
		tmp.setAnswer("Dangling pointer is obtained by using the address of an object which was freed.");
		tmp.setSetName("C++Questions");
		cPlusCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("Define Encapsulation?");
		tmp.setAnswer("Part of the information can be hidden about an object. Encapsulation isolates the internal functionality from the rest of the application.");
		tmp.setSetName("C++Questions");
		cPlusCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("Define Inheritance?");
		tmp.setAnswer("One class, called derived, can reuse the behavior of another class, known as base class. Methods of the base class can be extended by adding new proprieties or methods.");
		tmp.setSetName("C++Questions");
		cPlusCardList.add(tmp);
		
		QCardSet tmpSet = new QCardSet();
		tmpSet.setCardListName("C++Questions");
		tmpSet.setqCardsList(cPlusCardList);
		
		qCardSetList.add(tmpSet);
	}
	
	private void populateJavaCards(){
		
		QCard tmp = new QCard();
		
		tmp.setQuestion("How do you deal with dependency issues?");
		tmp.setAnswer("This question is purposely ambiguous. It can refer to solving the dependency injection problem (Guice is a standard tool to help). It can also refer to project dependencies � using external, third-party libraries. Tools like Maven and Gradle help manage them. You should consider learning more about Maven as a way to prepare for this question.");
		tmp.setSetName("JavaQuestions");
		javaCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("When and why are getters and setters important?");
		tmp.setAnswer("Setters and getters can be put in interfaces and can hide implementation details, so that you don�t have to make member variables public (which makes your class dangerously brittle).");
		tmp.setSetName("JavaQuestions");
		javaCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("How would you go about deciding between SOAP based web service and RESTful web service?");
		tmp.setAnswer("Web services are very popular and widely used to integrate disparate systems. It is imperative to understand the differences, pros, and cons between each approach. ");
		tmp.setSetName("JavaQuestions");
		javaCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("How to compare strings? Use �==� or use equals()?");
		tmp.setAnswer("In brief, �==� tests if references are equal and equals() tests if values are equal. Unless you want to check if two strings are the same object, you should always use equals().");
		tmp.setSetName("JavaQuestions");
		javaCardList.add(tmp);
		
		tmp = new QCard();
		tmp.setQuestion("What is the purpose of default constructor?");
		tmp.setAnswer("The default constructor provides the default values to the objects. The java compiler creates a default constructor only if there is no constructor in the class.");
		tmp.setSetName("JavaQuestions");
		javaCardList.add(tmp);
		
		QCardSet tmpSet = new QCardSet();
		tmpSet.setCardListName("JavaQuestions");
		tmpSet.setqCardsList(javaCardList);
		
		qCardSetList.add(tmpSet);
    	
    }
	public List<QCardSet> getqCardSetList() {
		return qCardSetList;
	}
	public void setqCardSetList(List<QCardSet> qCardSetList) {
		this.qCardSetList = qCardSetList;
	}
	public String getTheSetName() {
		return theSetName;
	}
	public void setTheSetName(String theSetName) {
		this.theSetName = theSetName;
	}

}
