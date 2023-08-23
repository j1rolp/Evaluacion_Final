package com.example.evc_final.data.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.evc_final.model.Ec_final;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class Ec_finalDao_Impl implements Ec_finalDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ec_final> __insertionAdapterOfEc_final;

  private final EntityDeletionOrUpdateAdapter<Ec_final> __deletionAdapterOfEc_final;

  public Ec_finalDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEc_final = new EntityInsertionAdapter<Ec_final>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `ec_final` (`id`,`img`,`name`,`height`,`allegiance`,`isFavorite`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ec_final value) {
        stmt.bindLong(1, value.getId());
        if (value.getImg() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getImg());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        if (value.getHeight() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHeight());
        }
        if (value.getAllegiance() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAllegiance());
        }
        final int _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(6, _tmp);
      }
    };
    this.__deletionAdapterOfEc_final = new EntityDeletionOrUpdateAdapter<Ec_final>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ec_final` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ec_final value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Object addFavorite(final Ec_final ec_final,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEc_final.insert(ec_final);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object borrarFavorite(final Ec_final ec_final,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEc_final.handle(ec_final);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<Ec_final> getFavorites() {
    final String _sql = "SELECT * FROM ec_final";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfHeight = CursorUtil.getColumnIndexOrThrow(_cursor, "height");
      final int _cursorIndexOfAllegiance = CursorUtil.getColumnIndexOrThrow(_cursor, "allegiance");
      final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
      final List<Ec_final> _result = new ArrayList<Ec_final>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ec_final _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getString(_cursorIndexOfImg);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpHeight;
        if (_cursor.isNull(_cursorIndexOfHeight)) {
          _tmpHeight = null;
        } else {
          _tmpHeight = _cursor.getString(_cursorIndexOfHeight);
        }
        final String _tmpAllegiance;
        if (_cursor.isNull(_cursorIndexOfAllegiance)) {
          _tmpAllegiance = null;
        } else {
          _tmpAllegiance = _cursor.getString(_cursorIndexOfAllegiance);
        }
        final boolean _tmpIsFavorite;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
        _tmpIsFavorite = _tmp != 0;
        _item = new Ec_final(_tmpId,_tmpImg,_tmpName,_tmpHeight,_tmpAllegiance,_tmpIsFavorite);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
