import com.example.todotutorial.practice.PracticeViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf

val appModule = module {
    viewModelOf(::PracticeViewModel)
}
