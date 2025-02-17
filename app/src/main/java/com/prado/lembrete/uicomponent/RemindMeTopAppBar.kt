package com.prado.lembrete.uicomponent

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.prado.lembrete.data.RemindMeRoute
import com.prado.lembrete.data.RemindMeTopLevelDestination
import com.prado.lembrete.data.TOP_LEVEL_DESTINATIONS
import com.prado.lembrete.utils.RemindMeContentType
import com.prado.lembrete.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemindMeTopAppBar(
	route: String,
	contentType: RemindMeContentType,
	modifier: Modifier = Modifier,
	showSaveButton: Boolean = false,
	onNavigationIconClicked: () -> Unit,
	onSettingClicked: () -> Unit = {},
	onTrashClicked: () -> Unit = {},
	onSaveClicked: () -> Unit = {},
) {
	
	CenterAlignedTopAppBar(
		modifier = modifier,
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = Color.Transparent
		),
		title = {},
		navigationIcon = {
			val supportedRoute = route == RemindMeRoute.REMINDER_DETAIL || route == RemindMeRoute.SETTING
			
			if (supportedRoute && contentType == RemindMeContentType.SINGLE_PANE) {
				IconButton(onClick = onNavigationIconClicked) {
					Icon(
						imageVector = Icons.Rounded.ArrowBack,
						contentDescription = null
					)
				}
			}
		},
		actions = {
			if (contentType == RemindMeContentType.SINGLE_PANE) {
				when (route) {
					RemindMeRoute.REMINDER_DETAIL -> {
						IconButton(onClick = onTrashClicked) {
							Icon(
								painter = painterResource(id = R.drawable.ic_trash),
								contentDescription = null
							)
						}
						
						if (showSaveButton) {
							IconButton(onClick = onSaveClicked) {
								Icon(
									imageVector = Icons.Rounded.Check,
									contentDescription = null
								)
							}
						}
					}
					RemindMeRoute.REMINDER_LIST -> {
						IconButton(onClick = onSettingClicked) {
							Icon(
								painter = painterResource(id = R.drawable.ic_setting),
								contentDescription = null
							)
						}
					}
				}
			} else {
				when (route) {
					RemindMeRoute.REMINDER_DETAIL -> {
						IconButton(onClick = onTrashClicked) {
							Icon(
								painter = painterResource(id = R.drawable.ic_trash),
								contentDescription = null
							)
						}
						
						if (showSaveButton) {
							IconButton(onClick = onSaveClicked) {
								Icon(
									imageVector = Icons.Rounded.Check,
									contentDescription = null
								)
							}
						}
					}
				}
			}
		}
	)
}

@Composable
fun RemindMeBottomNavigationBar(
	selectedDestination: String,
	navigateToTopLevelDestination: (RemindMeTopLevelDestination) -> Unit
) {
	NavigationBar(modifier = Modifier.fillMaxWidth()) {
		TOP_LEVEL_DESTINATIONS.forEach { replyDestination ->
			NavigationBarItem(
				selected = selectedDestination == replyDestination.route,
				onClick = { navigateToTopLevelDestination(replyDestination) },
				icon = {
					Icon(
						painter = painterResource(id = replyDestination.selectedIcon),
						contentDescription = stringResource(id = replyDestination.iconTextId)
					)
				}
			)
		}
	}
}
