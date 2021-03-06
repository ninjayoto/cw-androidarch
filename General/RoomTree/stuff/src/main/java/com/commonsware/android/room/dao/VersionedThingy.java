/***
 Copyright (c) 2017 CommonsWare, LLC
 Licensed under the Apache License, Version 2.0 (the "License"); you may not
 use this file except in compliance with the License. You may obtain	a copy
 of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
 by applicable law or agreed to in writing, software distributed under the
 License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
 OF ANY KIND, either express or implied. See the License for the specific
 language governing permissions and limitations under the License.

 Covered in detail in the book _Android's Architecture Components_
 https://commonsware.com/AndroidArch
 */

package com.commonsware.android.room.dao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import java.util.UUID;

@Entity(tableName="thingy", primaryKeys={"id", "version_code"})
class VersionedThingy {
  public final String id;

  @ColumnInfo(name="version_code")
  public final int versionCode;

  @Ignore
  private String something;

  @Ignore
  VersionedThingy() {
    this(UUID.randomUUID().toString(), 1);
  }

  VersionedThingy(String id, int versionCode) {
    this.id=id;
    this.versionCode=versionCode;
  }
}
