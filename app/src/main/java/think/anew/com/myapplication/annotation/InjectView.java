package think.anew.com.myapplication.annotation;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/9.
 */
public class InjectView {
    private static final String TAG = "InjectView";
    public static void init(final Activity activity){
        long start = System.currentTimeMillis();
        Field[] fields = activity.getClass().getFields();
        for(Field f : fields){
            if(f.isAnnotationPresent(BindView.class)){
                int value = f.getAnnotation(BindView.class).value();
                f.setAccessible(true);
                try {
                    f.set(activity, activity.findViewById(value));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    Log.d(TAG, "init IllegalAccessException ..." + e.getMessage());
                }
            };
        }

        Method[] methods = activity.getClass().getDeclaredMethods();
        for(final Method m : methods){
            if(m.isAnnotationPresent(OnClick.class)){
                int value = m.getAnnotation(OnClick.class).value();
                m.setAccessible(true);
                activity.findViewById(value).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            m.invoke(activity);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
        Log.d(TAG, "all time spand in annotation is : " + (System.currentTimeMillis() - start));
    }
}
