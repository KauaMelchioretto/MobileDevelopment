package com.example.simplepaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.skydoves.colorpickerview.ColorPickerView;

public class SimplePaint extends View {
    public boolean drawingSquare = false;
    Path myPath;
    Paint myPaint;
    private Square square;
    private Circle circle;
    Shapes drawShape;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        myPaint = new Paint();
        myPath = new Path();
        this.drawShape = Shapes.Path;

        myPaint.setColor(Color.BLACK);
        myPaint.setStrokeWidth(6f);
        myPaint.setAntiAlias(true);
        myPaint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        switch (this.drawShape) {
            case Square:
                canvas.drawRect(square.getSquareRect(), myPaint);
                break;
            case Path:
                canvas.drawPath(myPath, myPaint);
                break;
            case Circle:
                canvas.drawCircle(
                        circle.cX,
                        circle.cY,
                        circle.radius,
                        myPaint
                );
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                switch (drawShape) {
                    case Square:
                        square.setStart(x, y);
                        square.setEnd(x, y);
                        break;

                    case Path:
                        myPath.moveTo(x, y);
                        break;

                    case Circle:
                        circle.setStart(x, y);
                        break;
                }

                invalidate();
                return (true);

            case MotionEvent.ACTION_MOVE:
                switch (drawShape) {
                    case Square:
                        square.setEnd(x, y);

                    case Path :
                        myPath.lineTo(x, y);
                        break;

                    case Circle:
                        circle.setRadius(x, y);
                }
                invalidate();
                return (true);

            case MotionEvent.ACTION_UP:
                break;
        }

        myPath.lineTo(x, y);
        invalidate();
        return super.onTouchEvent(event);
    }

    public void setDrawingShape(Shapes shape) {
        this.drawShape = shape;

        if(shape.equals(Shapes.Square)) {
            square = new Square();
        }

        if(shape.equals(Shapes.Circle)) {
            circle = new Circle();
        }

        invalidate();
    }
}
