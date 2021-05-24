package org.akiapps.news.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import org.akiapps.news.base.BaseViewModel
import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import kotlin.reflect.KClass


@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CoursesActivityScope


@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)