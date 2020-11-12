package com.bugull.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import com.bugull.base.R;

/**
 * Create by @author wuxindi
 *
 * @time 2019/3/26  下午 1:58
 * @describe
 */
public class IOSDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout container;
    private TextView titleTv;
    private TextView msgTv;
    private TextView negBtn;
    private TextView posBtn;
    private ImageView img_line;
    private Display display;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;

    public IOSDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public IOSDialog init() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(R.layout.view_iosdialog, null);

        // 获取自定义Dialog布局中的控件
        container = (LinearLayout) view.findViewById(R.id.container);
        titleTv = (TextView) view.findViewById(R.id.txt_title);
        titleTv.setVisibility(View.GONE);
        msgTv = (TextView) view.findViewById(R.id.txt_msg);
        msgTv.setVisibility(View.GONE);
        negBtn = (TextView) view.findViewById(R.id.btn_neg);
        negBtn.setVisibility(View.GONE);
        posBtn = (TextView) view.findViewById(R.id.btn_pos);
        posBtn.setVisibility(View.GONE);
        img_line = (ImageView) view.findViewById(R.id.img_line);
        img_line.setVisibility(View.GONE);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        // 调整dialog背景大小
        container.setLayoutParams(
                new FrameLayout.LayoutParams(
                        (int) (display.getWidth() * 0.72),
                        LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }

    public IOSDialog setTitle(String title) {
        showTitle = true;
        if ("".equals(title)) {
            titleTv.setText("标题");
        } else {
            titleTv.setText(title);
        }
        return this;
    }

    public IOSDialog setTitle(SpannableString title) {
        showTitle = true;
        titleTv.setMovementMethod(LinkMovementMethod.getInstance());
        titleTv.setHighlightColor(context.getResources().getColor(android.R.color.transparent));
        titleTv.setText(title);
        return this;
    }

    public IOSDialog setTitleGravity(int gravity) {
        try{
            titleTv.setGravity(gravity);
        }catch (Exception e){
            titleTv.setGravity(Gravity.CENTER);
        }
        return this;
    }

    public IOSDialog setTitleSize(float size){
        try{
            titleTv.setTextSize(size);
        }catch (Exception e){ }
        return this;
    }

    public IOSDialog setMsg(String msg) {
        showMsg = true;
        if ("".equals(msg)) {
            msgTv.setText("内容");
        } else {
            msgTv.setText(msg);
        }
        return this;
    }

    public IOSDialog setMsg(SpannableString msg) {
        showMsg = true;
        msgTv.setMovementMethod(LinkMovementMethod.getInstance());
        msgTv.setHighlightColor(context.getResources().getColor(android.R.color.transparent));
        msgTv.setText(msg);
        return this;
    }

    public IOSDialog setMsgSize(float size){
        try{
            msgTv.setTextSize(size);
        }catch (Exception e){ }
        return this;
    }

    public IOSDialog setMsgGravity(int gravity) {
        try{
            msgTv.setGravity(gravity);
        }catch (Exception e){
            msgTv.setGravity(Gravity.CENTER);
        }
        return this;
    }

    public IOSDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public IOSDialog setPositiveButton(String text,
                                       final View.OnClickListener listener) {
        showPosBtn = true;
        if ("".equals(text)) {
            posBtn.setText("确定");
        } else {
            posBtn.setText(text);
        }
        posBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public IOSDialog setNegativeButton(String text, final View.OnClickListener listener) {
        showNegBtn = true;
        if ("".equals(text)) {
            negBtn.setText("取消");
        } else {
            negBtn.setText(text);
        }
        negBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    private void setLayout() {
        if (!showTitle && !showMsg) {
            titleTv.setText("提示");
            titleTv.setVisibility(View.VISIBLE);
        }

        if (showTitle) {
            titleTv.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            msgTv.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            posBtn.setText("确定");
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackground(context.getResources().getDrawable(R.drawable.bg_bottom_shape_selector));
            posBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn) {
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackground(context.getResources().getDrawable(R.drawable.bg_right_bottom_shape_selector));
            negBtn.setVisibility(View.VISIBLE);
            negBtn.setBackground(context.getResources().getDrawable(R.drawable.bg_left_bottom_shape_selector));
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            posBtn.setVisibility(View.VISIBLE);
            posBtn.setBackground(context.getResources().getDrawable(R.drawable.bg_bottom_shape_selector));
        }

        if (!showPosBtn && showNegBtn) {
            negBtn.setVisibility(View.VISIBLE);
            negBtn.setBackground(context.getResources().getDrawable(R.drawable.bg_bottom_shape_selector));
        }
    }

    public void show() {
        setLayout();
        dialog.show();
    }
}
