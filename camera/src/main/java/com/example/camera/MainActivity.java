package com.example.camera;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.camera.UI.CameraSurfaceView;
import com.example.camera.UI.RectOnCamera;

/**
 * 1.创建显示相机画面的布局，Android已经为我们选定好SurfaceView
 * 2.通过SurfaceView#getHolder()获得链接Camera和SurfaceView的SurfaceHolder
 * 3.Camame.open()打开相机
 * 4.通过SurfaceHolder链接Camera和SurfaceView
 */
public class MainActivity extends Activity implements View.OnClickListener, RectOnCamera.IAutoFocus {

    CameraSurfaceView mViewCamera;
    RectOnCamera mViewRect;
    Button mBtnTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        mViewCamera = (CameraSurfaceView) findViewById(R.id.view_camera);
        mViewRect = (RectOnCamera) findViewById(R.id.view_rect);
        mBtnTakePhoto = (Button) findViewById(R.id.btn_take_photo);
        mViewRect.setIAutoFocus(this);
        mBtnTakePhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_take_photo:
                mViewCamera.takePicture();
                break;
        }
    }

    @Override
    public void autoFocus() {
        mViewCamera.setAutoFocus();
    }
}
