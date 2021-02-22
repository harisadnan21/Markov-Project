import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov{
    private Map<WordGram,ArrayList<String>> myMap;

    public EfficientWordMarkov(){
        this(2);
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }
    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        //TODO: Clear and initialize myMap
        myMap.clear();
        for (int index = 0 ; index <= myWords.length - myOrder; index++){
            WordGram word = new WordGram(myWords,index,myOrder);
            ArrayList<String> arr = new ArrayList<>();

            myMap.putIfAbsent(word, arr);
            ArrayList<String> ar = myMap.get(word);
            if (index + myOrder >=  myWords.length){
                ar.add(PSEUDO_EOS);

            }
            else {
                String str = myWords[index + myOrder];
                ar.add(str);

                //ar.add(myWords.substring(index + myOrder, index + myOrder + 1));

            }



            myMap.put(word,ar);



        }


    }

    //TODO: Complete this method
    @Override
    public ArrayList<String> getFollows(WordGram key) {
        if (!myMap.containsKey(key)){
            throw new NoSuchElementException(key+" not in map");

        }


        return myMap.get(key);
    }
}
