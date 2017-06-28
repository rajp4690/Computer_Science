
package include;

import com.mtsystems.coot.Container;
import com.mtsystems.coot.IntContainer;
import com.mtsystems.coot.NativeClass;

/
public class IoMarker extends NativeClass {
	private final Container<Container<IoMarker>> next = new Container<Container<IoMarker>>(this, 1){};
	private final Container<Container<IoFile>> sbuf = new Container<Container<IoFile>>(this, 1){};
	private final IntContainer pos = new IntContainer(this, 1);
	public Container<IoMarker> getNext() {
		return next.get();
	}

	public Container<IoMarker> setNext(Container<IoMarker> newNext) {
		return next.set(newNext);
	}

	public Container<IoFile> getSbuf() {
		return sbuf.get();
	}

	public Container<IoFile> setSbuf(Container<IoFile> newSbuf) {
		return sbuf.set(newSbuf);
	}

	public int getPos() {
		return pos.get();
	}

	public int setPos(int newPos) {
		return pos.set(newPos);
	}
}
