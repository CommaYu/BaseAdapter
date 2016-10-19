# BaseAdapter
万能适配器
#说明
1、CommonAdapter里面基本不用修改  
2、VIewHolder里面，可以添加一些辅助方法，用于加载
#万能适配器使用方法
1、把utilsbyYsc包下的CommonAdapter和ViewHolder拷贝进入工程（不建议做成jar，因为ViewHolder可以自己升级）  
2、书写自己的Adapter（可以参照MyAdapterFour的写法，此种写法已经把R.layout.item把ListView中的item的布局提取出来了）  
3、setAdapter可以参照MainActivity中用法
#Bug
1、当item布局中出现CheckBox之类的，抢占了焦点的控件的时候，会出现item无法点击的问题，只能够点击CheckBox
分析：这个不是我们万能适配器的问题，是我们布局没有弄对。解决方法在我的Commits里面都有写  
（1） 在CheckBox写 android:focusable="false"  
（2） 大布局写   android:descendantFocusability="blocksDescendants"
此两种写法就可以解决
