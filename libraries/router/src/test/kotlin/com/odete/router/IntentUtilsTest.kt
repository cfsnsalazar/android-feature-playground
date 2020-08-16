package com.odete.router

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.matcher.IntentMatchers.hasFlags
import androidx.test.espresso.intent.matcher.IntentMatchers.hasPackage
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.js.denisvieira.featureplayground.commons.fileprovider.getApplicationId
import com.odete.router.vo.QRCodeScreenVO
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IntentUtilsTest {

    val intentUtils = IntentUtils()

    @Test
    fun shouldReturnInviteFriendIntent() {
        val action = "com.odete.membergetmember.ui.InviteFriendActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createInviteFriendIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnTimelineIntent() {
        val action = "com.odete.timeline.timeline.TimelineActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createTimelineIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnLoggedOutHelpIntent() {
        val action = "com.odete.attendance.loggedout.help.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createLoggedOutHelpIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnWalletIntent() {
        val action = "com.odete.wallet.WalletActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createWalletIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnWalletIntentWithFalse() {
        val action = "com.odete.wallet.WalletActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createWalletIntent(showButtonClose = false), hasAction(action))
    }

    @Test
    fun shouldReturnDetailWalletIntent() {
        val action = "com.odete.wallet.DetailWalletActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createDetailWalletIntent(1L), hasAction(action))
    }

    @Test
    fun shouldReturnWalletIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createWalletIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldReturnWalletIntentWithFalse_withApplicationIdForThisApp() {
        assertThat(intentUtils.createWalletIntent(false), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldReturnDetailWalletIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createDetailWalletIntent(1L), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldReturnTimelineIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createTimelineIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldReturnDetailTimelineIntent() {
        val action = "com.odete.timeline.detail.DetailActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createDetailTimelineIntent(String()), hasAction(action))
    }

    @Test
    fun shouldReturnDetailTimelineIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createDetailTimelineIntent(String()), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldReturnOnboarding() {
        val action = "br.com.odete.ONBOARDING.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createOnboardingIntent("13318351008"), hasAction(action))
    }

    @Test
    fun shouldReturnOnboarding_withApplicationIdForThisApp() {
        assertThat(
            intentUtils.createOnboardingIntent("13318351008"),
            hasPackage(getApplicationId())
        )
    }

    @Test
    fun shouldReturnOnboard() {
        val action = "com.odete.onboard.OnboardActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createOnboardIntent("13318351008"), hasAction(action))
    }

    @Test
    fun shouldReturnOnboard_withApplicationIdForThisApp() {
        assertThat(
            intentUtils.createOnboardIntent("13318351008"),
            hasPackage(getApplicationId())
        )
    }

    @Test
    fun shouldReturnLinkBrowser() {
        val action = "br.com.odete.Login.LinkBrowserActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createBrowserIntent("http://google.com.br"), hasAction(action))
    }

    @Test
    fun shouldReturnLinkBrowser_withApplicationIdForThisApp() {
        assertThat(
            intentUtils.createBrowserIntent("http://google.com.br"),
            hasPackage(getApplicationId())
        )
    }

    @Test
    fun whenGetSettings_shouldReturnSettingsIntentWithActionView() {
        assertThat(intentUtils.createSettingsIntent(), hasAction(Intent.ACTION_VIEW))
    }

    @Test
    fun whenGetSettings_shouldReturnSettingsIntentWithUri() {
        val uri = "app://odete.com/settings"
        assertThat(intentUtils.createSettingsIntent(), hasData(Uri.parse(uri)))
    }

    @Test
    fun whenGetLimitIntent_shouldReturnLimitIntent() {
        val action = "com.odete.limit.LimitActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createLimitIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnSettingsIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createSettingsIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun whenGetAccountCancellationIntent_shouldReturnCancellationIntent() {
        val action =
            "br.com.odete.accountcancellation.CancellationReasonsActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createAccountCancellationIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnAccountCancellationIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createAccountCancellationIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun whenGetAccountNewCardRequestIntent_shouldReturnNewCardReasonsIntent() {
        val action = "br.com.odete.android.newcard.CardRequestReasonsActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createAccountNewCardRequestIntent(), hasAction(action))
    }

    @Test
    fun shouldReturnAccountNewCardRequestIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createAccountNewCardRequestIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun whenGetFaqArticleIntent_shouldReturnNewCardReasonsIntent() {
        val action = "br.com.odete.attendance.FaqArticle.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createFaqArticleIntent("", ""), hasAction(action))
    }

    @Test
    fun shouldReturnFaqArticleIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createFaqArticleIntent("", ""), hasPackage(getApplicationId()))
    }

    @Test
    fun shouldHaveSetupAction() {
        val action = "br.com.odete.onboarding.setup.SetupActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createSetupIntent("13318351008"), hasAction(action))
    }

    @Test
    fun shouldHaveHomeAction() {
        val action = "br.com.odete.home.HomeActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createHomeIntent(), hasAction(action))
    }

    @Test
    fun whenAuthFlow_shouldHaveAuthFlowAction() {
        val action = "com.odete.auth.basic.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createAuthFlowIntent(), hasAction(action))
    }

    @Test
    fun whenAuthFlow_ShouldHaveApplicationIdForThisApp() {
        assertThat(intentUtils.createAuthFlowIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun whenLogout_shouldHaveLogoutAction() {
        val action = "com.odete.onboarding.logout.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createLogoutIntent(), hasAction(action))
    }

    @Test
    fun whenLogout_ShouldHaveApplicationIdForThisApp() {
        assertThat(intentUtils.createLogoutIntent(), hasPackage(getApplicationId()))
    }

    @Test
    fun whenHomeIntent_ShouldClearPreviousTasksAsFlags() {
        val intent = intentUtils.createHomeIntent()

        assertThat(
            intent,
            hasFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        )
    }

    @Test
    fun shouldReturnSetupIntent_withApplicationIdForThisApp() {
        assertThat(intentUtils.createSetupIntent("13318351008"), hasPackage(getApplicationId()))
    }

    @Test
    fun whenGetAppSettingsIntent_ShouldHaveSettingsAction() {
        assertThat(
            intentUtils.systemAppDetailsIntent(),
            hasAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        )
    }

    @Test
    fun whenGetAppSettingsIntent_ShouldHaveApplicationIdAsUri() {
        val expectedUri = Uri.parse("package:${getApplicationId()}")

        assertThat(intentUtils.systemAppDetailsIntent(), hasData(expectedUri))
    }

    @Test
    fun whenStartDispute_shouldHaveDisputeAction() {
        val action = "com.odete.dispute.DisputeActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createDisputeIntent("id", "amount"), hasAction(action))
    }

    @Test
    fun whenStartBenefitsStore_shouldHaveBenefitsStoreAction() {
        val action = "com.odete.benefitsstore.ui.view.BenefitsStoreActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createBenefitsStoreIntent(), hasAction(action))
    }

    @Test
    fun whenStartQRCodeScreen_shouldHaveQRCodeAction() {
        val action =
            "com.odete.library.qrcodescreen.ui.view.QRCodeScreenActivity.${BuildConfig.FLAVOR}"
        assertThat(
            intentUtils.createQRCodeScreenIntent(
                QRCodeScreenVO(
                    "button",
                    "scan",
                    "authorization",
                    "toolbar"
                )
            ),
            hasAction(action)
        )
    }

    @Test
    fun whenStartDispute_shouldHaveExtraValues() {
        val transactionId = "id"
        val amountValue = "amount"

        val intent = intentUtils.createDisputeIntent(transactionId, amountValue)

        assertThat(intent, hasExtra(TRANSACTION_ID_EXTRA, transactionId))
        assertThat(intent, hasExtra(TRANSACTION_AMOUNT_EXTRA, amountValue))
    }

    @Test
    fun whenStartDispute_shouldHaveApplicationIdForThisApp() {
        val intent = intentUtils.createDisputeIntent("id", "amount")
        assertThat(intent, hasPackage(getApplicationId()))
    }

    @Test
    fun whenStartNewCardDeliveryTracking_shouldNewCardDeliveryTrackingAction() {
        val action =
            "com.odete.settings.newcard.delivery.tracking.view.DeliveryTrackingActivity.${BuildConfig.FLAVOR}"
        assertThat(intentUtils.createAccountNewCardDeliveryTrackingIntent(), hasAction(action))
    }

    private fun getApplicationId() = getApplicationId(BuildConfig.FLAVOR_TYPE_SULFIX)
}
