package include;

import static com.mtsystems.coot.NativeInformation.INT_SIZE;
import static com.mtsystems.coot.NativeInformation.LONG_SIZE;
import static com.mtsystems.coot.NativeInformation.POINTER_SIZE;

import com.mtsystems.coot.AbstractData;
import com.mtsystems.coot.Container;
import com.mtsystems.coot.IntContainer;
import com.mtsystems.coot.LongContainer;
import com.mtsystems.coot.NativeClass;
import com.mtsystems.coot.ShortContainer;
import com.mtsystems.coot.String8;

public class IoFile extends NativeClass {
	private final IntContainer flags = new IntContainer(this, 1);
	private final Container<String8> ioReadPtr = new Container<String8>(this, 1){};
    private final Container<String8> ioReadEnd = new Container<String8>(this, 1){};
    private final Container<String8> ioReadBase = new Container<String8>(this, 1){};
    private final Container<String8> ioWriteBase = new Container<String8>(this, 1){};
    private final Container<String8> ioWritePtr = new Container<String8>(this, 1){};
    private final Container<String8> ioWriteEnd = new Container<String8>(this, 1){};
	private final Container<String8> ioBufBase = new Container<String8>(this, 1){};
    private final Container<String8> ioBufEnd = new Container<String8>(this, 1){};
	private final Container<String8> ioSaveBase = new Container<String8>(this, 1){};
    private final Container<String8> ioBackupBase = new Container<String8>(this, 1){};
	private final Container<String8> ioSaveEnd = new Container<String8>(this, 1){};
    private final Container<Container<IoMarker>> markers = new Container<Container<IoMarker>>(this, 1){};

	private final Container<Container<IoFile>> chain = new Container<Container<IoFile>>(this, 1){};

	private final IntContainer fileno = new IntContainer(this, 1);

	private final IntContainer flags2 = new IntContainer(this, 1);
	private final LongContainer oldOffset = new LongContainer(this, 1);

	private final ShortContainer curColumn_U = new ShortContainer(this, 1);

	private final String8 vtableOffset = new String8(this, 1);

	private final String8 shortbuf = new String8(this, 1);

	
	private final Container<AbstractData> lock = new Container<AbstractData>(this, 1){};

	private final LongContainer offset = new LongContainer(this, 1);

	private final Container<AbstractData> pad1 = new Container<AbstractData>(this, 1){};

	private final Container<AbstractData> pad2 = new Container<AbstractData>(this, 1){};

	private final Container<AbstractData> pad3 = new Container<AbstractData>(this, 1){};

	private final Container<AbstractData> pad4 = new Container<AbstractData>(this, 1){};

	private final LongContainer pad5_U = new LongContainer(this, 1);

	private final IntContainer mode = new IntContainer(this, 1);

	private final String8 unused2 = new String8(this, (int)(15 * ((long)INT_SIZE) - 4 * ((long)POINTER_SIZE) - ((long)LONG_SIZE)));

	public int getFlags() {
		return flags.get();
	}

	public int setFlags(int newFlags) {
		return flags.set(newFlags);
	}

	public String8 getIoReadPtr() {
		return ioReadPtr.get();
	}

	public String8 setIoReadPtr(String8 newIoReadPtr) {
		return ioReadPtr.set(newIoReadPtr);
	}

	public String8 getIoReadEnd() {
		return ioReadEnd.get();
	}

	public String8 setIoReadEnd(String8 newIoReadEnd) {
		return ioReadEnd.set(newIoReadEnd);
	}

	public String8 getIoReadBase() {
		return ioReadBase.get();
	}

	public String8 setIoReadBase(String8 newIoReadBase) {
		return ioReadBase.set(newIoReadBase);
	}

	public String8 getIoWriteBase() {
		return ioWriteBase.get();
	}

	public String8 setIoWriteBase(String8 newIoWriteBase) {
		return ioWriteBase.set(newIoWriteBase);
	}

	public String8 getIoWritePtr() {
		return ioWritePtr.get();
	}

	public String8 setIoWritePtr(String8 newIoWritePtr) {
		return ioWritePtr.set(newIoWritePtr);
	}

	public String8 getIoWriteEnd() {
		return ioWriteEnd.get();
	}

	public String8 setIoWriteEnd(String8 newIoWriteEnd) {
		return ioWriteEnd.set(newIoWriteEnd);
	}

	public String8 getIoBufBase() {
		return ioBufBase.get();
	}

	public String8 setIoBufBase(String8 newIoBufBase) {
		return ioBufBase.set(newIoBufBase);
	}

	public String8 getIoBufEnd() {
		return ioBufEnd.get();
	}

	public String8 setIoBufEnd(String8 newIoBufEnd) {
		return ioBufEnd.set(newIoBufEnd);
	}

	public String8 getIoSaveBase() {
		return ioSaveBase.get();
	}

	public String8 setIoSaveBase(String8 newIoSaveBase) {
		return ioSaveBase.set(newIoSaveBase);
	}

	public String8 getIoBackupBase() {
		return ioBackupBase.get();
	}

	public String8 setIoBackupBase(String8 newIoBackupBase) {
		return ioBackupBase.set(newIoBackupBase);
	}

	public String8 getIoSaveEnd() {
		return ioSaveEnd.get();
	}

	public String8 setIoSaveEnd(String8 newIoSaveEnd) {
		return ioSaveEnd.set(newIoSaveEnd);
	}

	public Container<IoMarker> getMarkers() {
		return markers.get();
	}

	public Container<IoMarker> setMarkers(Container<IoMarker> newMarkers) {
		return markers.set(newMarkers);
	}

	public Container<IoFile> getChain() {
		return chain.get();
	}

	public Container<IoFile> setChain(Container<IoFile> newChain) {
		return chain.set(newChain);
	}

	public int getFileno() {
		return fileno.get();
	}

	public int setFileno(int newFileno) {
		return fileno.set(newFileno);
	}

	public int getFlags2() {
		return flags2.get();
	}

	public int setFlags2(int newFlags2) {
		return flags2.set(newFlags2);
	}

	public long getOldOffset() {
		return oldOffset.get();
	}

	public long setOldOffset(long newOldOffset) {
		return oldOffset.set(newOldOffset);
	}

	public short getCurColumn_U() {
		return curColumn_U.get();
	}

	public short setCurColumn_U(short newCurColumn_U) {
		return curColumn_U.set(newCurColumn_U);
	}

	public byte getVtableOffset() {
		return vtableOffset.get();
	}

	public byte setVtableOffset(byte newVtableOffset) {
		return vtableOffset.set(newVtableOffset);
	}

	public String8 getShortbuf() {
		return shortbuf;
	}

	public AbstractData getLock() {
		return lock.get();
	}

	public AbstractData setLock(AbstractData newLock) {
		return lock.set(newLock);
	}

	public long getOffset() {
		return offset.get();
	}

	public long setOffset(long newOffset) {
		return offset.set(newOffset);
	}

	public AbstractData getPad1() {
		return pad1.get();
	}

	public AbstractData setPad1(AbstractData newPad1) {
		return pad1.set(newPad1);
	}

	public AbstractData getPad2() {
		return pad2.get();
	}

	public AbstractData setPad2(AbstractData newPad2) {
		return pad2.set(newPad2);
	}

	public AbstractData getPad3() {
		return pad3.get();
	}

	public AbstractData setPad3(AbstractData newPad3) {
		return pad3.set(newPad3);
	}

	public AbstractData getPad4() {
		return pad4.get();
	}

	public AbstractData setPad4(AbstractData newPad4) {
		return pad4.set(newPad4);
	}

	public long getPad5_U() {
		return pad5_U.get();
	}

	public long setPad5_U(long newPad5_U) {
		return pad5_U.set(newPad5_U);
	}

	public int getMode() {
		return mode.get();
	}

	public int setMode(int newMode) {
		return mode.set(newMode);
	}

	public String8 getUnused2() {
		return unused2;
	}
}