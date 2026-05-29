class RandomizedSet {
    private HashMap<Integer, Integer> mainSet;
    private ArrayList<Integer> randomArr;

    public RandomizedSet() {
        this.mainSet = new HashMap<>();
        this.randomArr = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mainSet.containsKey(val)){
            return false;
        }
        if(randomArr.size() <= mainSet.size()){
            randomArr.add(val);
            mainSet.put(val, randomArr.size() - 1);
        }else{
            int size = mainSet.size();
            randomArr.set(mainSet.size(), val);
            mainSet.put(val, size);
        }
        return true;
    }
    
    public boolean remove(int val) {
        if(!mainSet.containsKey(val)){
            return false;
        }
        if(mainSet.get(val) + 1 == mainSet.size()){
            mainSet.remove(val);
        }else{
            int pos = mainSet.get(val);
            int endVal = randomArr.get(mainSet.size() - 1);
            mainSet.put(endVal, pos);
            randomArr.set(pos, endVal);
            mainSet.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        int max = mainSet.size() - 1;
        int min = 0;
        int randomNum = rand.nextInt(max - min + 1) + min;
        return randomArr.get(randomNum);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */