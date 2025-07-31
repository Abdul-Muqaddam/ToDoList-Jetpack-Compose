import androidx.room.Room
import com.example.todotutorial.data.app_data_base.AppDataBase
import com.example.todotutorial.data.repository.TaskRepository
import com.example.todotutorial.practice.PracticeViewModel
import com.example.todotutorial.presentation.LanguageScreen.LanguageScreenViewModel
import com.example.todotutorial.presentation.dashboard_screen.DashboardViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf

val appModule = module {
    viewModelOf(::PracticeViewModel)
    viewModelOf(::LanguageScreenViewModel)
    viewModelOf(::DashboardViewModel)

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDataBase::class.java,
            "TodoList"
        ).build()
    }

    single { get<AppDataBase>().taskDao() }

    single { TaskRepository(get()) }

}
