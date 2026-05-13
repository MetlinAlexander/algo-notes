- если у нас есть матрица, которую мы обходим, то можно сделать вокруг барьер - это упростит задачу
- метод зайца и черепахи
- массив сдвигов
- бинарный поиск(правый/левый) можно проверит на ситуации, когда остается два элемента
- в хорошем бинарном поиске должен быть только if и else
```C++
// left binary search | min i : (X <= a[i])
LLint leftBinSearch(LLint l, LLint r, std::vector<LLint> &arr, LLint x){
    LLint m;
    while(l < r){
        m = (l+r)/2;
        if(x <= arr[m]){
            r = m;
        }else{
            l = m + 1;
        }
    }
    return l;
}

// right binary search | max i : (X >= a[i])
LLint rightBinarySearch(LLint l, LLint r, std::vector<LLint> &arr, LLint x){
    LLint m;
    while (l < r){
        m = (l+r+1)/2;
        if(x>=arr[m]){
            l = m;
        }else{
            r = m-1;
        }
    }
    return l;
}
```