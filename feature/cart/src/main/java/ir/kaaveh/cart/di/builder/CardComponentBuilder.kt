package ir.kaaveh.cart.di.builder

import com.phelat.tedu.androidcore.di.builder.AndroidCoreComponentBuilder
import com.phelat.tedu.androidresource.di.builder.AndroidResourceComponentBuilder
import com.phelat.tedu.coroutines.di.builder.ThreadComponentBuilder
import com.phelat.tedu.dependencyinjection.ComponentBuilder
import com.phelat.tedu.dependencyinjection.StartupTasks
import com.phelat.tedu.navigation.di.builder.NavigationComponentBuilder
import com.phelat.tedu.networking.di.builder.NetworkingComponentBuilder
import ir.kaaveh.cart.di.component.CardComponent
import ir.kaaveh.cart.di.component.DaggerCardComponent

object CardComponentBuilder : ComponentBuilder<CardComponent>() {

    override fun initializeComponent(addStartupTask: (StartupTasks) -> Unit): CardComponent {
        return DaggerCardComponent.builder()
            .threadComponent(ThreadComponentBuilder.getComponent(addStartupTask))
            .networkingComponent(NetworkingComponentBuilder.getComponent(addStartupTask))
            .androidResourceComponent(AndroidResourceComponentBuilder.getComponent(addStartupTask))
            .androidCoreComponent(AndroidCoreComponentBuilder.getComponent(addStartupTask))
            .navigationComponent(NavigationComponentBuilder.getComponent(addStartupTask))
            .build()
    }
}