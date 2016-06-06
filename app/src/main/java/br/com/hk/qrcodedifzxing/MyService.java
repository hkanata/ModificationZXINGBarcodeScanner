package br.com.hk.qrcodedifzxing;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;

public class MyService extends Service {

    private SurfaceHolder.Callback mHolder;
    private WindowManager mWindowManager;
    public LayoutInflater minflater;
    private QRCodeReaderView mydecoderview;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mydecoderview = new QRCodeReaderView(this);

        minflater = (LayoutInflater)getSystemService (LAYOUT_INFLATER_SERVICE);
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        FrameLayout mParentView = new FrameLayout(getApplicationContext());
        final WindowManager.LayoutParams params1 = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                PixelFormat.TRANSPARENT);
        params1.width = 1;
        params1.height = 1;
        mWindowManager.addView(mParentView, params1);
        mHolder = mydecoderview;
        mParentView.addView(mydecoderview);

        mHolder = new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mydecoderview.setOnQRCodeReadListener(new QRCodeReaderView.OnQRCodeReadListener() {
                    @Override
                    public void onQRCodeRead(String text, PointF[] points) {
                        Log.i("Resultado", ""+text);
                    }

                    @Override
                    public void cameraNotFound() {
                        Log.i("Resultado", "cameraNotFound");
                    }

                    @Override
                    public void QRCodeNotFoundOnCamImage() {
                        Log.i("Resultado", "QRCodeNotFoundOnCamImage");
                    }
                });

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        };
        mHolder.surfaceCreated(mydecoderview.getHolder());
    }
}
