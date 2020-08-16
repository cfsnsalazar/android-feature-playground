//package org.js.denisvieira.features.signin
//
//import android.content.ContentValues.TAG
//import android.content.Context.INPUT_METHOD_SERVICE
//import android.content.Intent
//import android.graphics.Bitmap
//import android.graphics.Typeface
//import android.graphics.drawable.BitmapDrawable
//import android.graphics.drawable.Drawable
//import android.net.Uri
//import android.os.Bundle
//import android.text.TextPaint
//import android.text.TextUtils
//import android.text.method.LinkMovementMethod
//import android.text.style.ClickableSpan
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.view.inputmethod.InputMethodManager
//import android.widget.EditText
//import androidx.annotation.NonNull
//import androidx.core.content.ContextCompat
//import androidx.databinding.DataBindingUtil.inflate
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
//import androidx.navigation.fragment.findNavController
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.target.CustomTarget
//import com.facebook.CallbackManager
//import com.facebook.login.widget.LoginButton
//import com.google.android.gms.auth.api.Auth
//import com.google.android.gms.auth.api.signin.*
//import com.google.android.gms.common.api.ApiException
//import com.google.android.gms.tasks.Task
//import com.google.android.material.snackbar.Snackbar
//import com.google.firebase.FirebaseApp
//import com.google.firebase.auth.FirebaseAuth
//import com.izio.R
//import com.izio.application.helper.FragmentBase
//import com.izio.application.helper.facebookcallback.FBCallbackManager
//import com.izio.application.helper.facebookcallback.FacebookCallBackDelegate
//import com.izio.application.helper.facebookcallback.UserFacebook
//import com.izio.application.utils.SpanUtils
//import com.izio.domain.constants.TokenTypesEnum
//import org.js.denisvieira.features.signin.dto.SimpleAuthDto
//import org.js.denisvieira.features.signin.dto.SocialAuthDto
//import com.izio.application.helper.extensions.observeEvent
//import com.izio.application.helper.quickformrules.NotEmptyRule
//import com.izio.application.helper.quickformrules.SixCharactersMinPasswordRule
//import com.izio.application.modules.signin.SignInViewModel
//import com.izio.application.utils.ImageUtil.decodeSampledBitmapFromResource
//import com.izio.databinding.SignInFragmentBinding
//import com.mobsandgeeks.saripaar.ValidationError
//import com.mobsandgeeks.saripaar.Validator
//import com.mobsandgeeks.saripaar.annotation.NotEmpty
//import java.util.*
//
//class SignInFragment : FragmentBase(), FacebookCallBackDelegate, Validator.ValidationListener {
//
//    private lateinit var mBinding: SignInFragmentBinding
//    private lateinit var mSignInViewModel: SignInViewModel
//    private lateinit var mAuthFormValidator: Validator
//    private lateinit var mCallbackManager: CallbackManager
//    private lateinit var mSimpleAuthDto: SimpleAuthDto
//    private lateinit var mButtonFacebookLogin: LoginButton
//    private lateinit var mAuth: FirebaseAuth
//    private lateinit var mGoogleSignInClient: GoogleSignInClient
//    private var RC_SIGN_IN_FACEBOOK: Int = 3232
//    private var RC_SIGN_IN_GOOGLE: Int = 6565
//
//    @NotEmpty
//    private lateinit var emailField : EditText
//    @NotEmpty
//    private lateinit var passwordField : EditText
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
//        mBinding = inflate(inflater, R.layout.sign_in_fragment, container, false)
//
//        FirebaseApp.initializeApp(context!!)
//
//        emailField = mBinding.emailAuthEditText
//        passwordField = mBinding.passwordAuthEditText
//
//        return mBinding.root
//    }
//
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        mSignInViewModel = ViewModelProviders.of(this,
//            SignInViewModel.SignInViewModelFactory(context!!)
//        ).get(SignInViewModel::class.java)
//        startObservers()
//        initElements()
//
//        val token = "354731641614-gvu1g08pef8t0g8if6ntt4t56o2umt9c.apps.googleusercontent.com"
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
////            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        mGoogleSignInClient = GoogleSignIn.getClient(activity!!, gso)
//        mBinding.signInGoogleSignButton.setOnClickListener {
//            onClickGoogleSignIn()
//        }
//
//        val mSignUpHereTextButton = SpanUtils.createClickableSpan(
//            "",
//            getString(R.string.sign_in_do_sign_up_here), getClickableSpanToSignUp()
//        )
//
//        mBinding.signInSignUpTextView.text = TextUtils.concat(getString(R.string.sign_in_do_sign_up), mSignUpHereTextButton)
//        mBinding.signInSignUpTextView.movementMethod = LinkMovementMethod.getInstance()
//
//        val imm = activity!!.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view!!.windowToken, 0)
//
//        val ob = BitmapDrawable(resources, decodeSampledBitmapFromResource(resources, R.drawable.bg, 200, 200))
//        mBinding.signInMainGeneralContainer.background = ob
//
//        mAuthFormValidator.setValidationListener(this)
//    }
//
//    private fun getClickableSpanToSignUp(): ClickableSpan {
//        return object : ClickableSpan() {
//            override fun onClick(@NonNull textView: View) {
//                onClickSignUp()
//            }
//
//            override fun updateDrawState(@NonNull textPaint: TextPaint) {
//                super.updateDrawState(textPaint)
//                setTextStyle(textPaint)
//            }
//        }
//    }
//
//    private fun onClickSignUp() {
//        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
//    }
//
//    private fun setTextStyle(textPaint: TextPaint) {
//        textPaint.isUnderlineText = true
//        textPaint.typeface = Typeface.DEFAULT_BOLD
//        textPaint.color = ContextCompat.getColor(context!!, R.color.light_blue)
//    }
//
//    private fun initElements() {
//        setupFragmentBinding()
//        setupValidator()
//        mAuth = FirebaseAuth.getInstance()
//        setupFacebookLogin()
//    }
//
//    private fun startObservers() {
//        startSignInSuccessObserver()
//        startOnErrorMainDataObserver()
//    }
//
//    private fun startSignInSuccessObserver() {
//        mSignInViewModel.mAuthObservers.onSuccessMainDataObserver.observeEvent(this) {
//            goToMainScreen()
//        }
//    }
//
//    private fun startOnErrorMainDataObserver() {
//        mSignInViewModel.mAuthObservers.onErrorMainDataObserver.observe(this, Observer {
//            showAlert(it)
//        })
//    }
//
//
//    private fun setupFragmentBinding() {
//        mSimpleAuthDto = SimpleAuthDto("", "")
//
//        mBinding.lifecycleOwner = this
//        mBinding.handler        = this
//        mBinding.viewModel      = mSignInViewModel
//        mBinding.simpleAuthDto  = mSimpleAuthDto
//    }
//
//    private fun setupValidator() {
//        mAuthFormValidator = Validator(mBinding)
//        mAuthFormValidator.put(mBinding.emailAuthEditText,  NotEmptyRule(0))
//        mAuthFormValidator.put(mBinding.passwordAuthEditText,  NotEmptyRule(0),
//            SixCharactersMinPasswordRule(0))
//    }
//
//    private fun setupFacebookLogin() {
//        mBinding.signInFacebookLoginButton.setOnClickListener{
//            mBinding.signInRealFacebookLoginButton.performClick()
//        }
//        mCallbackManager              = CallbackManager.Factory.create()
//        mButtonFacebookLogin          = mBinding.signInRealFacebookLoginButton
//        mButtonFacebookLogin.fragment = this
//
//        FBCallbackManager(mButtonFacebookLogin, this, mCallbackManager, context!!)
//    }
//
//    override fun fbCallbackOnSuccess(userFacebook: UserFacebook) {
//        mBinding.passwordAuthTextInputLayout.requestFocus()
//        mBinding.progressBar.visibility = View.VISIBLE
//
//        sendUserLoggedToApi(userFacebook, TokenTypesEnum.FACEBOOK.value)
//    }
//
//    private fun sendUserLoggedToApi(userFacebook: UserFacebook, tokenType: Int) {
//        // TODO solicitar permissão do campo user_birthday e remover data de nascimento fake
//
//        val socialAuthDto = SocialAuthDto(
//            name = userFacebook.displayName,
//            email = userFacebook.email,
//            birthdayDate = Date(),
//            token = userFacebook.token,
//            tokenType = tokenType,
//            socialId = userFacebook.facebookId,
//            profileImage = userFacebook.profileImage
//        )
//
//        mSignInViewModel.authSocial(socialAuthDto)
//    }
//
//    override fun fbCallbackOnError(localizedMessage: String) {
//        mBinding.progressBar.visibility = View.GONE
//        showAlert(localizedMessage)
//    }
//
//    override fun fbCallbackOnCancel() {
//        mBinding.progressBar.visibility = View.GONE
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        mCallbackManager.onActivityResult(requestCode, resultCode, data)
////        mSignUpFormDialog.setupAddImageOnActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN_GOOGLE) {
//            // The Task returned from this call is always completed, no need to attach
//            // a listener.
//            val result :GoogleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
//            val statusCode : Int = result.status.statusCode
//
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            handleSignInResult(task)
//        }
//
//        super.onActivityResult(requestCode, resultCode, data)
//    }
//
//    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
//        try {
//            val account = completedTask.getResult(ApiException::class.java)
//            Log.w(TAG, "signInResult:success - \n " + account.toString())
//
//            if(account!!.photoUrl == null ) {
//                val userFacebook = UserFacebook(
//                    facebookId = account.id!!,
//                    email = account.email!!,
//                    displayName = account.displayName!!,
//                    token = account.idToken!!,
//                    profileImage = null
//                )
//
//                sendUserLoggedToApi(userFacebook, TokenTypesEnum.GOOGLE.value)
//            } else {
//                getGoogleProfilePicture(account.photoUrl, getTarget(account))
//            }
//
//        } catch (e: ApiException) {
//            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
//        }
//
//    }
//
//    private fun getTarget(account: GoogleSignInAccount): CustomTarget<Bitmap> {
//        return object : CustomTarget<Bitmap>(){
//            override fun onLoadCleared(placeholder: Drawable?) {
//
//            }
//
//            override fun onResourceReady(
//                resource: Bitmap,
//                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
//            ) {
//                val userFacebook = UserFacebook(
//                    facebookId = account.id!!,
//                    email = account.email!!,
//                    displayName = account.displayName!!,
//                    token = account.idToken!!,
//                    profileImage = resource
//                )
//
//                sendUserLoggedToApi(userFacebook, TokenTypesEnum.GOOGLE.value)
//            }
//
//        }
//    }
//
//    private fun getGoogleProfilePicture(imageURL: Uri?, target: CustomTarget<Bitmap>){
//        Glide.with(this)
//            .asBitmap()
//            .load(imageURL)
//            .into(target)
//    }
//
//    fun auth(simpleAuthDto: SimpleAuthDto) {
//        mAuthFormValidator.validate()
//        mSimpleAuthDto = simpleAuthDto
//    }
//
//    private fun onClickGoogleSignIn() {
//        val signInIntent = mGoogleSignInClient.signInIntent
//
//        startActivityForResult(signInIntent, RC_SIGN_IN_GOOGLE)
//    }
//
//    private fun goToMainScreen() {
//        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToFirstSignInFragment())
//    }
//
//    fun onPressForgotPassword(view: View) {
//        findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToForgotPasswordFragment())
//    }
//
//    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
//        if(errors!!.isNotEmpty()) {
//            Snackbar.make(mBinding.root, errors[0].getCollatedErrorMessage(context), Snackbar.LENGTH_SHORT)
//                .setBackgroundTint(ContextCompat.getColor(context!!, R.color.light_yellow)).show()
//        }
//    }
//
//    override fun onValidationSucceeded() {
//        mSignInViewModel.auth(mSimpleAuthDto)
//
//    }
//
//
//}
