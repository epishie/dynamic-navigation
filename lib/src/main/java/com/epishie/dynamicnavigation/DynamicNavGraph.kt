package com.epishie.dynamicnavigation

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.withStyledAttributes
import androidx.navigation.NavGraph
import androidx.navigation.NavInflater

class DynamicNavGraph(navigator: DynamicNavigator, private val navInflater: NavInflater) :
    NavGraph(navigator) {

    override fun onInflate(context: Context, attrs: AttributeSet) {
        super.onInflate(context, attrs)
        context.withStyledAttributes(attrs, R.styleable.DynamicGraph, 0, 0) {
            val graphPackage = getString(R.styleable.DynamicGraph_graphPackage)
            val graphName = getString(R.styleable.DynamicGraph_graphName)
            val id = context.resources.getIdentifier(
                graphName,
                DEF_TYPE_NAVIGATION,
                graphPackage
            )
            if (id == 0) {
                throw IllegalStateException("Unable to find resource: $graphPackage:$DEF_TYPE_NAVIGATION/$graphName")
            }
            val graph = navInflater.inflate(id)
            addAll(graph)
            startDestination = graph.startDestination
        }
    }

    private companion object {
        const val DEF_TYPE_NAVIGATION = "navigation"
    }
}
