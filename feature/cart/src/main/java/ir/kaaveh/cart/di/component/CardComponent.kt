package ir.kaaveh.cart.di.component

import com.phelat.tedu.androidcore.di.component.AndroidCoreComponent
import com.phelat.tedu.androiddagger.DispatcherComponent
import com.phelat.tedu.androidresource.di.component.AndroidResourceComponent
import com.phelat.tedu.coroutines.di.component.ThreadComponent
import com.phelat.tedu.dependencyinjection.feature.FeatureScope
import com.phelat.tedu.navigation.di.component.NavigationComponent
import com.phelat.tedu.networking.di.component.NetworkingComponent
import dagger.Component
import dagger.android.AndroidInjectionModule
import ir.kaaveh.cart.di.module.CardFragmentModule

@FeatureScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        CardFragmentModule::class
    ],
    dependencies = [
        ThreadComponent::class,
        NetworkingComponent::class,
        AndroidResourceComponent::class,
        AndroidCoreComponent::class,
        NavigationComponent::class
    ]
)
interface CardComponent : DispatcherComponent