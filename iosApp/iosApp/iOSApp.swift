import SwiftUI
import Shared

@main
struct iOSApp: App {

    init() {
        SetupKoinDIKt.doInitKoin()
    
    }

    var body: some Scene {
        WindowGroup {
            MovieSearchView()
        }
    }
}
