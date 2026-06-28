class candies {
    public int candy(int[] ratings) {
        int sum = 0;
        if(ratings.length == 1) return 1;
        int arr[] = new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            arr[i] = 1;
        }
        for(int i=0;i<ratings.length;i++){
            if(i != 0 && ratings[i] > ratings[i-1]) arr[i] = arr[i-1]+1;
        }

        for(int i=ratings.length-1;i>=0;i--){
            if(i != ratings.length-1 && ratings[i] > ratings[i+1]) arr[i] = Math.max(arr[i],arr[i+1]+1);
            sum += arr[i];
        }
        return sum;
    }
}