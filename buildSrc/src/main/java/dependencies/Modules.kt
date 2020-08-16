package dependencies

object Modules {

    const val ROUTER = ":libraries:router"
    const val HOME = ":home"
    const val DI = ":di"

    object Commons {
        const val COMMONS_CORE = ":commons"
        const val COMMONS_TEST = ":commons-test"
        const val NATIVE_TYPE = ":commons:nativetype"
    }

    object Application {
        const val APP = ":app"
        const val SAMPLE_STYLEGUIDE = ":sample-styleguide"
    }

    object Analytics {
        const val ANALYTICS = ":analytics:analytics"
        const val ADJUST = ":analytics:adjust"
        const val DEVICE = ":analytics:device"
    }

    object Network {
        const val CORE = ":network:network-core"
        const val PROVIDER = ":network:network-provider"
    }

    object Library {
        const val STATES = ":library:state"
        const val SESSION = ":library:session"
        const val DI_NAVIGATION = ":library:di-navigation"
        const val EVENTS = ":libraries:events"
    }

    object Authentication {
        const val SIGN_IN = ":features:authentication:sign-in"
        const val SIGN_UP = ":features:authentication:sign-up"
    }

}
