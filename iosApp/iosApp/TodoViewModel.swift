//
//  TodoViewModel.swift
//  iosApp
//
//  Created by cw-ryu.nakayama on 2023/08/29.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class TodoViewModel: ObservableObject {
    let todoItemList = TodoItemList()

    init() {
        todoItemList.addNewItem(name: "1つ目")
        todoItemList.addNewItem(name: "2つ目")
    }
}
