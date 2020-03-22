/**
 * Copyright © 2020 Skull Scoring (Sébastien BALARD)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sebastienbalard.skullscoring.di

import androidx.room.Room
import com.sebastienbalard.skullscoring.data.SKDatabase
import org.koin.dsl.module
import java.util.concurrent.Executors

val dataTestModule = module {
    factory {
        Room.inMemoryDatabaseBuilder(
            get(), SKDatabase::class.java
        ).setTransactionExecutor(Executors.newSingleThreadExecutor()).build()
    }
    factory { get<SKDatabase>().getGameDao() }
    factory { get<SKDatabase>().getPlayerDao() }
    factory { get<SKDatabase>().getTurnDao() }
    factory { get<SKDatabase>().getGamePlayerJoinDao() }
    factory { get<SKDatabase>().getTurnPlayerJoinDao() }
}
