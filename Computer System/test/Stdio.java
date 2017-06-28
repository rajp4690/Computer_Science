package include;

import com.mtsystems.coot.AbstractData;
import com.mtsystems.coot.Container;
import com.mtsystems.coot.NativeHelper;
import com.mtsystems.coot.String8;

public class Stdio {
	static {
		
		NativeHelper h = NativeHelper.get("libc.so.6");
		h.addRename("fread_U", "fread");
		h.bindDirect(Stdio.class);
	}
	public static native int fclose(Container<IoFile> stream);
    public static native Container<IoFile> fopen(String8 filename, String8 modes);
	public static native long fread_U(AbstractData ptr, long size_U, long n_U, Container<IoFile> stream);
}
