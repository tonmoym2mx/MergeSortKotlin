package com.example.mergesort

fun main(){
    val array = intArrayOf(4, 2, 1, 3,3,5,7,8,9,6,7,8,62,1,-1)
    array.mergeSort()
    array.printArray()
}

fun IntArray.mergeSort() {
    mergeSort(this,0, size -1)
}
fun IntArray.printArray(separator:String = ","){

    this.forEachIndexed{index, i ->
        val lastIndex = this.size-1
        print("$i${if(index != lastIndex) separator else ""}")
    }
}
fun mergeSort(array: IntArray, left: Int, right: Int){
    if(left<right){
        val middle = left + (right-left)/2
        mergeSort(array, left = left, right = middle)
        mergeSort(array, left = middle + 1, right = right)

        merge(array, left = left, middle = middle, right = right)
    }

}


private fun merge(array: IntArray, left: Int, middle: Int, right: Int) {
    val n1 = (middle-left)+1
    val n2 = right-middle

    val leftArray:Array<Int> = Array(n1){ i -> array[left + i]}
    val rightArray:Array<Int> = Array(n2){ i -> array[middle + 1 + i] }

    var i = 0
    var j = 0
    var k = left

    while (i<n1 && j < n2){
        if(leftArray[i]<=rightArray[j]){
            array[k] = leftArray[i]
            i++
        }else{
            array[k] = rightArray[j]
            j++
        }
        k++
    }

    while (i < n1) {
        array[k] = leftArray[i]
        i++
        k++
    }


    while (j < n2) {
        array[k] = rightArray[j]
        j++
        k++
    }

}