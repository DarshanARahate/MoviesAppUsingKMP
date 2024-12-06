import Foundation
import Shared

func collect<T>(stateFlow:CommonStateFlow<T>,onEach: @escaping (T)->Void) async{

    var collectionCancelled : CheckedContinuation<Void,Never>?
    
    
    let cancellable = stateFlow.startCollection(onEach: {value in onEach(value!)}, onCancel: {collectionCancelled?.resume()})
    
    await withTaskCancellationHandler(operation: { await withCheckedContinuation{continuation in collectionCancelled = continuation}}, onCancel: {cancellable.onCancel()})
    
}
