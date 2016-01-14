package de.kularts.bertee.Controller;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by oli on 14.01.16.
 */
public class TypefaceController {

    public static TypefaceController instance;
    private Context context;

    public TypefaceController(Context context){
        this.context = context;
    }

    // SINGLETON METHODS
    public static void initInstance(Context context){
        if(instance == null){
            instance = new TypefaceController(context);
        }
    }

    public static TypefaceController getInstance(){
        return instance;
    }


    public Typeface getTypeface(TypefaceWeight weight){

        Typeface font = null;

        if(TypefaceWeight.Normal.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Regular.ttf");
        }
        else if(TypefaceWeight.Thin.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Thin.ttf");
        }
        else if(TypefaceWeight.Light.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Light.ttf");
        }
        else if(TypefaceWeight.Hairline.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Hairline.ttf");
        }
        else if(TypefaceWeight.Bold.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Bold.ttf");
        }
        else if(TypefaceWeight.Black.equals(weight)){
            font = Typeface.createFromAsset(context.getAssets(),  "fonts/Lato-Black.ttf");
        }

        return font;
    }
}
