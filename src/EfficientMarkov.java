import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		//TODO: Clear and initialize myMap
		myMap.clear();
		for (int index = 0 ; index <= myText.length() - myOrder; index++){
			String str = myText.substring(index, index + myOrder);
			ArrayList<String> arr = new ArrayList<>();

			myMap.putIfAbsent(str, arr);
			ArrayList<String> ar = myMap.get(str);
			if (index + myOrder >=  myText.length()){
				ar.add(PSEUDO_EOS);

			}
			else {
				ar.add(myText.substring(index + myOrder, index + myOrder + 1));

			}



			myMap.put(str,ar);



		}


	}

	//TODO: Complete this method
	@Override
	public ArrayList<String> getFollows(String key) {
		if (!myMap.containsKey(key)){
			throw new NoSuchElementException(key+" not in map");

		}


		return myMap.get(key);
	}
}	
