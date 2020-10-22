package com.gptlike.sparseArr;

/**
 * @description: 稀疏数组  含有大量无效数据的二维数组转化为更省内存的稀疏数组
 * 稀疏数组三列 row col val
 * @auto : mzh
 * @create: 2020-09-22 22:02
 **/
public class SparseArr {
    public static void main(String[] args) {
        /**
         * 创建二维数组并赋值
         * 11*11的棋盘
         * 0代表没有棋子，1代表黑子，2代表白子
         * 第一行第二列黑子
         * 第二行第三列白子
         */
        int[][] arr=new int[11][11];
        arr[0][1]=1;
        arr[1][2]=2;
        arr[2][3]=2;
        /*遍历二维数组*/
        forArr(arr);
        /**
         * 二维数组转化为稀疏数组
         * 1）遍历二维数组，获取有效数据个数sum确定几行，用于创建稀疏数组
         * 2) 添加稀疏数组第一行数据，行、列、sum
         * 2）遍历二维数组，获取有效数据存入稀疏数组（从第二行开始）
         */
        //默认有效数据0个
        int sum=0;
        for (int[] arrs:arr){
            for (int data:arrs){
                //当该位置有棋子则sum++
                if(data!=0){
                    sum++;
                }
            }
        }
        //创建count用于向稀疏数组中存放数据
        int count=1;
        //创建稀疏数组
        int[][] sparseArr=new int[sum+1][3];
        //稀疏数组的第一列存入行列和sum
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //再次遍历二维数组往稀疏数组存放数据
        for (int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                //有效数据进行存入稀疏数组，从第二行开始存
                if(arr[i][j]!=0){
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                    count++;
                }
            }
        }
        /*遍历稀疏数组*/
        forSparseArr(sparseArr);
        /**
         * 稀疏数组转化为二维数组
         * 1）根据稀疏数组第一行的数据创建二维数组
         * 2）从稀疏数组第二行开始遍历，数据存入二维数组
         */
        //创建二维数组
        int[][] newArr=new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组将有效值存入二维数组
        for(int i=1;i<sparseArr.length;i++){
            newArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        /*遍历稀疏数组*/
        forArr(newArr);
    }


    /**
     * 遍历稀疏数组，用于显示
     * @param arr-稀疏数组
     */
    private static void forArr(int[][] arr){
        System.out.println("遍历稀疏数组--------------------------------");
        for (int[] arrs:arr){
            for (int data:arrs){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * 遍历二维数组，用于显示
     * @param sparseArr
     */
    private static void forSparseArr(int[][] sparseArr){
        System.out.println("遍历二维数组--------------------------------");
        for(int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
    }
}
