import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        IosModulProviderKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			NewsListView()
		}
	}
}
