package com.whut.vs.widgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.whut.vegetableshop.R;


/***
 * 均匀分布在屏幕上的宫格（如：3*3，4*4等）
 * @author simon
 * @date 2015-10-21
 */
public class AdvancedGridView extends TableLayout{

//  private static final String tag = "AdvancedGridView";  
    
    private int rowNum = 0; // row number  
    private int colNum = 0; // column number  
      
    private BaseAdapter adapter = null;   
      
    private Context context = null;
    
    private OnItemClickListener onItemClickListener;//item选项监听器
    
    private View.OnClickListener myOnClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			int id = v.getId();
			if (onItemClickListener != null) {
				onItemClickListener.onItemClick(id);
			}
		}
	};
      
    public AdvancedGridView(Context context) {
    	this(context, null);
    }  
  
    public AdvancedGridView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        init(context, attrs);  
    }
    
    
  
    private void init(Context context, AttributeSet attrs) {  
        this.context =  context;
        
        //读取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.AdvancedGridView);
        rowNum = typedArray.getInteger(R.styleable.AdvancedGridView_row, 0);
        colNum = typedArray.getInteger(R.styleable.AdvancedGridView_column, 0);
        typedArray.recycle();
        
        if (this.getTag() != null) {  
            String atb = (String) this.getTag();  
            int ix = atb.indexOf(',');  
            if (ix > 0) {  
                rowNum = Integer.parseInt(atb.substring(0, ix));  
                colNum = Integer.parseInt(atb.substring(ix+1, atb.length()));  
            }  
        }  
        if (rowNum <= 0)  
            rowNum = 3;  
        if (colNum <= 0)  
            colNum = 3;  
  
        if(this.isInEditMode()){  
            this.removeAllViews();  
            for(int y=0; y<rowNum; ++y){  
                TableRow row = new TableRow(context);  
                row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));  
                for(int x=0; x<colNum; ++x){  
                    View button = new Button(context);  
                    row.addView(button, new TableRow.LayoutParams (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));  
                }  
                this.addView(row);  
            }  
        }  
    }  
  
    public BaseAdapter getAdapter() {  
        return adapter;  
    }  
  
    public void setAdapter(BaseAdapter adapter) {  
        if(adapter != null){  
            if(adapter.getCount() < this.rowNum*this.colNum){  
                throw new IllegalArgumentException("The view count of adapter is less than this gridview's items");  
            }  
            this.removeAllViews();  
            for(int y = 0; y < rowNum; y++){  
                TableRow row = new TableRow(context);  
                row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));  
                for(int x = 0; x < colNum; x++){  
                    View view = adapter.getView(y*colNum+x, this, row);
                    view.setId(y*colNum+x);
                    view.setOnClickListener(myOnClickListener);
                    row.addView(view, new TableRow.LayoutParams (LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f));  
                }  
                this.addView(row);  
            }  
        }  
        this.adapter = adapter;  
    }  
  
    public int getRowNum() {  
        return rowNum;  
    }  
  
    public void setRowNum(int rowNum) {  
        this.rowNum = rowNum;  
    }  
  
    public int getColNum() {  
        return colNum;  
    }  
  
    public void setColNum(int colNum) {  
        this.colNum = colNum;  
    }
    
    public OnItemClickListener getOnItemClickListener() {
		return onItemClickListener;
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}



	public interface OnItemClickListener{
    	public void onItemClick(int id);
    }
	
}
